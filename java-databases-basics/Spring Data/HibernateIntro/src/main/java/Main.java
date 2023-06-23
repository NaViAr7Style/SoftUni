import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = new Student("Gosho", 15);
        session.save(student);

        Student student1 = session.get(Student.class, 1);
        System.out.println(student1);

        List<Student> allStudents = session
                .createQuery("FROM Student WHERE name = 'Gosho'", Student.class)
                .stream()
                .toList();

        allStudents.forEach(System.out::println);

        session.getTransaction().commit();
        session.close();

    }

}