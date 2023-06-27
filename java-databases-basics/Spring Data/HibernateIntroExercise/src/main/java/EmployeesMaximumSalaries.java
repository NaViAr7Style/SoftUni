import javax.persistence.EntityManager;

public class EmployeesMaximumSalaries {

    public static void main(String[] args) {

        final EntityManager entityManager = Utils.createEntityManager();

        entityManager.createQuery("SELECT department.name, max(salary) " +
                        "FROM Employee " +
                        "GROUP BY department.name " +
                        "HAVING max(salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList()
                .forEach(object ->
                        System.out.printf("%s %.2f\n",
                        object[0],
                        Double.parseDouble(object[1].toString())));

        entityManager.close();
    }
}

