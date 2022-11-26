package lecture04BStreamsFilesAndDirectoriesExercise;

import java.io.*;

public class P04CountCharacterTypes {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("resources/input.txt");
        PrintWriter pw = new PrintWriter(new FileWriter("resources/output.txt"));

        int oneByte = fr.read();

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        while (oneByte >= 0) {
            char symbol = (char) oneByte;

            if (isVowel(symbol)) {
                vowels++;
            } else if (isPunctuation(symbol)) {
                punctuation++;
            } else if (!Character.isWhitespace(symbol)){
                consonants++;
            }

            oneByte = fr.read();
        }

        pw.println("Vowels: " + vowels);
        pw.println("Consonants: " + consonants);
        pw.println("Punctuation: " + punctuation);

        fr.close();
        pw.close();
    }

    private static boolean isPunctuation(char symbol) {
        return symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?';
    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u';
    }
}
