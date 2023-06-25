import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class AddingANewAddressAndUpdatingTheEmployee {

    private static final String ADDRESS_TEXT = "Vitoshka 15";
    private static final String TOWN_NAME = "SOFIA"; //All caps because it was changed in a previous problem

    public static void main(String[] args) {

        final EntityManager entityManager = Utils.createEntityManager();
        final Scanner scanner = new Scanner(System.in);

        final String employeeLastName = scanner.nextLine();

        entityManager.getTransaction().begin();

        final Town townForNewAddress = entityManager
                .createQuery("FROM Town WHERE name = :townName", Town.class)
                .setParameter("townName", TOWN_NAME)
                .getSingleResult();

        Address newAddress = new Address();
        newAddress.setText(ADDRESS_TEXT);
        newAddress.setTown(townForNewAddress);

        entityManager.persist(newAddress);

        List<Employee> employeeList = entityManager
                .createQuery("FROM Employee WHERE lastName = :searchedName", Employee.class)
                .setParameter("searchedName", employeeLastName)
                .getResultList();

        employeeList.forEach(e -> e.setAddress(newAddress));

        entityManager.getTransaction().commit();
        entityManager.close();
        scanner.close();
    }

}
