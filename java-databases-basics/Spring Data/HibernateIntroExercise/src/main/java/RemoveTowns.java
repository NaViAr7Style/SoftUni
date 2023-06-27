import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RemoveTowns {

    public static void main(String[] args) {

        final EntityManager entityManager = Utils.createEntityManager();
        final Scanner scanner = new Scanner(System.in);

        String townToDelete = scanner.nextLine();

        entityManager.getTransaction().begin();

        List<Address> addressList = entityManager
                .createQuery("FROM Address WHERE town.name = :townToDelete", Address.class)
                .setParameter("townToDelete", townToDelete)
                .getResultList();

        if (addressList.isEmpty()) {
            System.out.printf("Town %s doesn't exist!\n", townToDelete);
            entityManager.getTransaction().rollback();
            return;
        }

        int addressCount = addressList.size();

        Town town = addressList.get(0).getTown();

        addressList.forEach(a -> {
            Set<Employee> employees = a.getEmployees();
            employees.forEach(e -> e.setAddress(null));
            entityManager.remove(a);
        });

        entityManager.remove(town);

        entityManager.getTransaction().commit();

        String addressConjugation = addressCount == 1
                ? "address"
                : "addresses";

        System.out.printf("%d %s in %s deleted\n", addressCount, addressConjugation, townToDelete);

        entityManager.close();
    }
}