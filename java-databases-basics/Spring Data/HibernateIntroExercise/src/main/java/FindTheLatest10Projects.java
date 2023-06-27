import entities.Project;

import javax.persistence.EntityManager;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class FindTheLatest10Projects {

    private static final String PRINT_FORMAT = "Project name: %s\n" +
            "\tProject Description: %s\n" +
            "\tProject Start Date: %s\n" +
            "\tProject End Date: %s\n";

    public static void main(String[] args) {

        final EntityManager entityManager = Utils.createEntityManager();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.s");
        //Time prints with a 3-hour difference because the time has been set to UTC in the JDBC string in the persistence.xml file

        entityManager
                .createQuery("FROM Project ORDER BY startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultStream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf(PRINT_FORMAT,
                                                p.getName(),
                                                p.getDescription(),
                                                formatter.format(p.getStartDate()),
                                                p.getEndDate())
                );

        entityManager.close();
    }
}
