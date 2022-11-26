package lecture04AInterfacesAndAbstractionLab.sayHello;

import java.util.ArrayList;
import java.util.List;

public class P03P04SayHello {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Bulgarian("Peter"));
        people.add(new European("Peter"));
        people.add(new Chinese("Peter"));

        for (Person person : people) {
            System.out.println(person.sayHello());
        }
    }

}