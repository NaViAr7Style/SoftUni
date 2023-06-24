import javax.persistence.EntityManager;

public class AddingANewAddressAndUpdatingTheEmployee {

    public static void main(String[] args) {

        EntityManager entityManager = Utils.createEntityManager();

//        Vitoshka 15

        entityManager.close();
    }

}
