package lecture01BWorkingWithAbstractionExercise.cardsWithPower;

import lecture01BWorkingWithAbstractionExercise.cardRank.CardRank;
import lecture01BWorkingWithAbstractionExercise.cardSuit.CardSuit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CardRank cardRank = CardRank.valueOf(scanner.nextLine());
        CardSuit cardSuit = CardSuit.valueOf(scanner.nextLine());

        System.out.printf("Card name: %s of %s; Card power: %d%n", cardRank.name(), cardSuit.name(), cardRank.getPower() + cardSuit.getPower());
    }
}