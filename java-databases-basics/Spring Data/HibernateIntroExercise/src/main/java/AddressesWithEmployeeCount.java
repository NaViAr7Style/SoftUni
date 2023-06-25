import entities.Address;

import javax.persistence.EntityManager;

public class AddressesWithEmployeeCount {

    private static final String PRINT_FORMAT = "%s, %s - %d employees\n";

    public static void main(String[] args) {

        final EntityManager entityManager = Utils.createEntityManager();

        entityManager
                .createQuery("FROM Address ORDER BY employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(e -> System.out.printf(PRINT_FORMAT,
                            e.getText(),
                            e.getTown().getName(),
                            e.getEmployees().size())
                );

        entityManager.close();
    }

}
