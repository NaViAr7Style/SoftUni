package lecture06AObjectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06Students2 {
    static class Student {
        String firstName;
        String lastName;
        String age;
        String hometown;

        public Student(String firstName, String lastName, String age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getAge() {
            return this.age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getHometown() {
            return this.hometown;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Student> studentList = new ArrayList<>();

        while (!input.equals("end")) {
            String[] inputArr = input.split(" ");
            String currentFirstName = inputArr[0];
            String currentLastName = inputArr[1];
            String currentAge = inputArr[2];
            String currentHometown = inputArr[3];

            if (isStudentExisting(studentList, currentFirstName, currentLastName)) {
                Student currentStudent = getStudent(studentList, currentFirstName, currentLastName);

                currentStudent.setAge(currentAge);
                currentStudent.setHometown(currentHometown);
            } else {
                Student currentStudent = new Student(currentFirstName, currentLastName, currentAge, currentHometown);
                studentList.add(currentStudent);
            }

            input = scanner.nextLine();
        }

        String town = scanner.nextLine();

        List<Student> filterStudents = studentList.stream().filter(e -> e.getHometown().equals(town)).collect(Collectors.toList());

        for (Student student : filterStudents) {
            System.out.printf("%s %s is %s years old%n", student.getFirstName(), student.getLastName(), student.getAge());
        }
    }

    public static boolean isStudentExisting(List<Student> studentList, String firstName, String lastName) {
        for (Student student : studentList) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    private static Student getStudent(List<Student> studentList, String firstName, String lastName) {
        Student existingStudent = null;

        for (Student student : studentList) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }

        return existingStudent;
    }
}
