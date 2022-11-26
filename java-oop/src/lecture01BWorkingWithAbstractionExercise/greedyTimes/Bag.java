package lecture01BWorkingWithAbstractionExercise.greedyTimes;

import java.util.*;

public class Bag {
    private final long capacity;
    private final List<Item> items;

    public Bag(long capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public void put(Item item) {

        if (!isStorable(item)) {
            return;
        }

        Item matchingItem = items.stream()
                .filter(e -> e.getItemName().equalsIgnoreCase(item.getItemName()))
                .findFirst()
                .orElse(null);

        if (matchingItem != null) {
            matchingItem.addAmount(item.getAmount());
        } else {
            items.add(item);
        }
    }

    private boolean isStorable(Item item) {
        boolean isStorable = capacity >= getTotalAmount() + item.getAmount();

        switch (item.getItemType()) {
            case GEM:
                if (item.getAmount() + getAmount(ItemType.GEM) > getAmount(ItemType.GOLD)) {
                    isStorable = false;
                }
                break;
            case CASH:
                if (item.getAmount() + getAmount(ItemType.CASH) > getAmount(ItemType.GEM)) {
                    isStorable = false;
                }
                break;
        }

        return isStorable;
    }

    private long getAmount(ItemType itemType) {
        return items.stream()
                .filter(e -> e.getItemType().equals(itemType))
                .mapToLong(Item::getAmount)
                .sum();
    }

    private long getTotalAmount() {
        return getAmount(ItemType.GOLD) + getAmount(ItemType.GEM) + getAmount(ItemType.CASH);
    }

    @Override
    public String toString() {
        String output = getGoldString() +
                System.lineSeparator() +
                getGemsString() +
                System.lineSeparator() +
                getCashString();

        return output.trim();
    }

    private String getGoldString() {
        Item hasGold = getMatchingItem(ItemType.GOLD);

        if (hasGold == null) {
            return "";
        }

        return "<Gold> $" +
                getAmount(ItemType.GOLD) +
                System.lineSeparator() +
                "##Gold - " +
                getAmount(ItemType.GOLD);
    }

    private String getGemsString() {
        Item hasGem = getMatchingItem(ItemType.GEM);

        if (hasGem == null) {
            return "";
        }

        StringBuilder gems = new StringBuilder();

        gems.append("<Gem> $").append(getAmount(ItemType.GEM));

        items.stream()
                .filter(e -> e.getItemType().equals(ItemType.GEM))
                .sorted(Comparator.comparing(Item::getItemName).reversed())
                .forEach(gem -> gems.append(System.lineSeparator())
                        .append("##")
                        .append(gem.getItemName())
                        .append(" - ")
                        .append(gem.getAmount()));

        return gems.toString();
    }

    private String getCashString() {
        Item hasCash = getMatchingItem(ItemType.CASH);

        if (hasCash == null) {
            return "";
        }

        StringBuilder cash = new StringBuilder();

        cash.append("<Cash> $").append(getAmount(ItemType.CASH));
        items.stream()
                .filter(e -> e.getItemType().equals(ItemType.CASH))
                .sorted(Comparator.comparing(Item::getItemName).reversed())
                .forEach(currency -> cash.append(System.lineSeparator())
                        .append("##")
                        .append(currency.getItemName())
                        .append(" - ")
                        .append(currency.getAmount()));

        return cash.toString();
    }

    private Item getMatchingItem(ItemType itemType) {
        return items.stream()
                .filter(e -> e.getItemType().equals(itemType))
                .findAny()
                .orElse(null);
    }
}