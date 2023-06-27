import entities.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class IncreaseSalaries {

    private static final List<String> DEPARTMENT_NAMES_TO_INCREASE_SALARIES = List.of(
            "Engineering",
            "Tool Design",
            "Marketing",
            "Information Services"
    );

    public static void main(String[] args) {

        final EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

        List<Employee> employees = entityManager
                .createQuery("FROM Employee WHERE department.name IN (:departments)", Employee.class)
                .setParameter("departments", DEPARTMENT_NAMES_TO_INCREASE_SALARIES)
                .getResultList();

        employees.forEach(e -> e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12))));

        entityManager.getTransaction().commit();

        employees.forEach(e ->
                System.out.printf("%s %s ($%s)\n",
                                    e.getFirstName(),
                                    e.getLastName(),
                                    e.getSalary().setScale(2, RoundingMode.HALF_EVEN)));

        entityManager.close();
    }
}
