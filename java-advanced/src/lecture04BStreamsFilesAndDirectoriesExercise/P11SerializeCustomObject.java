package lecture04BStreamsFilesAndDirectoriesExercise;

import java.io.*;

public class P11SerializeCustomObject {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Course course = new Course();

        course.name = "Java Advanced September 2022";
        course.numberOfStudents = 250;

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("resources/courses.ser"));
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("resources/courses.ser"));

        output.writeObject(course);

        Course courseFromFile = (Course) input.readObject();

        System.out.println(courseFromFile.numberOfStudents);
        System.out.println(courseFromFile.name);
    }
}
