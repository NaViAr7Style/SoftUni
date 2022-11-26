package lecture04BStreamsFilesAndDirectoriesExercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class P10SerializeArrayList {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Double> list = new ArrayList<>();

        list.add(1.1);
        list.add(2.2);
        list.add(3.3);

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("resources/list.ser"));
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("resources/list.ser"));

        output.writeObject(list);

        List<Double> listFromFile = (List<Double>) input.readObject();

        System.out.println(listFromFile);
    }
}