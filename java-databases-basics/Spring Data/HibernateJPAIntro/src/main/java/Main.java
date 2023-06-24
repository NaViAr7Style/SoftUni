import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Student student = new Student("Kani");
        em.persist(student);

        em.getTransaction().commit();

        List<Student> studentList = new ArrayList<>();

        studentList.add(student);

        studentList.forEach(System.out::println);
    }
}