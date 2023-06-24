import entities.Employee;

import javax.persistence.EntityManager;

public class EmployeesWithASalaryOver50K {

    public static void main(String[] args) {

        final EntityManager entityManager = Utils.createEntityManager();

        entityManager
                .createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                .getResultList()
                .forEach(e -> System.out.println(e.getFirstName()));

        entityManager.close();
    }

}
