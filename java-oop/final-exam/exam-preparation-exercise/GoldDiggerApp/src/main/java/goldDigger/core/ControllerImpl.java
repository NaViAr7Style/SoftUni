package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

import java.util.List;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    private Repository<Discoverer> discoverers;
    private Repository<Spot> spots;
    private int inspectedSpotsCount;

    public ControllerImpl() {
        discoverers = new DiscovererRepository();
        spots = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {

        Discoverer discoverer;

        switch (kind) {
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }

        discoverers.add(discoverer);

        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {

        Spot spot = new SpotImpl(spotName);

        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }

        spots.add(spot);

        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {

        Discoverer discoverer = discoverers.byName(discovererName);

        if (discoverer == null) {
            String errorMessage = String.format(DISCOVERER_DOES_NOT_EXIST, discovererName);
            throw new IllegalArgumentException(errorMessage);
        }

        discoverers.remove(discoverer);

        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {

        List<Discoverer> suitableDiscoverers = discoverers.getCollection().stream()
                .filter(d -> d.getEnergy() > 45)
                .collect(Collectors.toList());

        if (suitableDiscoverers.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        Operation operation = new OperationImpl();
        Spot spot = spots.byName(spotName);

        operation.startOperation(spot, suitableDiscoverers);
        inspectedSpotsCount++;

        long exhaustedDiscoverers = suitableDiscoverers.stream()
                .filter(d -> d.getEnergy() == 0)
                .count();

        return String.format(INSPECT_SPOT, spotName, exhaustedDiscoverers);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_SPOT_INSPECT, inspectedSpotsCount))
                .append(System.lineSeparator())
                .append(FINAL_DISCOVERER_INFO);

        for (Discoverer discoverer : discoverers.getCollection()) {
            String museumExhibits = String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, discoverer.getMuseum().getExhibits());

            if (museumExhibits.trim().isEmpty()) {
                museumExhibits = "None";
            }

            sb.append(System.lineSeparator())
                    .append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()))
                    .append(System.lineSeparator())
                    .append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, museumExhibits));
        }

        return sb.toString();
    }

}
