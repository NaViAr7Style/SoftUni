import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class ContainsEmployee {

    public static void main(String[] args) {

        final EntityManager entityManager = Utils.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        String searchedName = scanner.nextLine();

        entityManager.getTransaction().begin();

        final String isEmployeePresent = entityManager
                .createQuery("FROM Employee WHERE CONCAT_WS(' ', firstName, lastName) = :fullName", Employee.class)
                .setParameter("fullName", searchedName)
                .getResultList()
                .isEmpty()
                    ? "No"
                    : "Yes";

        System.out.println(isEmployeePresent);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
