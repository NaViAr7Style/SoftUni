package lecture02AEncapsulationLab;

import java.text.DecimalFormat;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName, age, 460);
    }

    public void increaseSalary(double bonus) {
        double updatedBonus = age < 30 ? bonus / 2 : bonus;

        double factor = 1.00 + updatedBonus / 100;

        setSalary(salary * factor);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0##");

        return String.format("%s %s is %s years old.", firstName, lastName, df.format(salary));
    }

    private void validateNameLength(String name, String messagePrefix) {
        if (name.length() < 3) {
            throw new IllegalStateException(messagePrefix + " name cannot be less than 3 symbols");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateNameLength(firstName, "First");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateNameLength(lastName, "Last");
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalStateException("Age cannot be zero or negative integer");
        }

        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalStateException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }
}