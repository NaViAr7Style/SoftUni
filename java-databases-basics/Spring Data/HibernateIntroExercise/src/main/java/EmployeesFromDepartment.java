import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeesFromDepartment {

    public static void main(String[] args) {

        final EntityManager entityManager = Utils.createEntityManager();

        final List<Employee> employeeList = entityManager
                .createQuery("FROM Employee WHERE department.name = :dName ORDER BY salary, id", Employee.class)
                .setParameter("dName", "Research and Development")
                .getResultList();

        for (Employee employee : employeeList) {
            System.out.printf("%s %s from %s - $%s\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment().getName(),
                    employee.getSalary());
        }

        entityManager.close();
    }

}
