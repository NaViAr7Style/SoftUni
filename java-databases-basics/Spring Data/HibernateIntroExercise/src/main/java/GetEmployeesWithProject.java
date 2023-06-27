import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class GetEmployeesWithProject {

    private static final String PRINT_EMPLOYEE = "%s %s - %s\n";

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final EntityManager entityManager = Utils.createEntityManager();

        int employeeId = Integer.parseInt(scanner.nextLine());

        try {
            Employee employee = entityManager
                    .createQuery("FROM Employee WHERE id = :employeeId", Employee.class)
                    .setParameter("employeeId", employeeId)
                    .getSingleResult();

            System.out.printf(PRINT_EMPLOYEE, employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

            employee
                .getProjects()
                .stream()
                .map(Project::getName)
                .sorted()
                .forEach(p -> System.out.printf("\t%s\n", p));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        entityManager.close();
        scanner.close();
    }

}
