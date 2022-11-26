package lecture09BIteratorsAndComparatorsExercise;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        setName(name);
        setAge(age);
        setTown(town);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {
        int result = this.getName().compareTo(other.getName());

        if (result == 0) {
            result = Integer.compare(this.getAge(), other.getAge());
        }

        if (result == 0) {
            result = this.getTown().compareTo(other.getTown());
        }

        return result;
    }
}
