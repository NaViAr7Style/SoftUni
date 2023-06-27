import entities.Employee;

import javax.persistence.EntityManager;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

public class FindEmployeesByFirstName {

    private static final String PRINT_FORMAT = "%s %s - %s - ($%s)\n";

    public static void main(String[] args) {

        final EntityManager entityManager = Utils.createEntityManager();
        final Scanner scanner = new Scanner(System.in);

        String pattern = scanner.nextLine();
        pattern += "%";

        List<Employee> employees = entityManager
                .createQuery("FROM Employee WHERE firstName LIKE :pattern", Employee.class)
                .setParameter("pattern", pattern)
                .getResultList();

        employees
                .forEach(e -> System.out.printf(PRINT_FORMAT,
                        e.getFirstName(),
                        e.getLastName(),
                        e.getJobTitle(),
                        e.getSalary().setScale(2, RoundingMode.HALF_EVEN)));

        entityManager.close();
    }
}
