import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.Scanner;

public class GetEmployeesWithProject {

    private static final String PRINT_EMPLOYEE = "%s %s - %s\n";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EntityManager entityManager = Utils.createEntityManager();

        int employeeId = Integer.parseInt(scanner.nextLine());

        try {
            Employee employee = entityManager
                    .createQuery("FROM Employee WHERE id = :id", Employee.class)
                    .setParameter("id", employeeId)
                    .getSingleResult();

            System.out.printf(PRINT_EMPLOYEE, employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

            employee
                .getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf("\t%s\n", p.getName()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        entityManager.close();
        scanner.close();
    }

}
