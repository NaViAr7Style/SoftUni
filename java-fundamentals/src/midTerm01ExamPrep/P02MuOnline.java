package midTerm01ExamPrep;

import java.util.Scanner;

public class P02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dungeon = scanner.nextLine().split("\\|");
        int health = 100;
        int bitcoins = 0;

        for (int i = 0; i < dungeon.length; i++) {
            String[] room = dungeon[i].split(" ");
            String action = room[0];
            int value = Integer.parseInt(room[1]);

            switch (action) {
                case "potion":
                    int oldHealth = health;
                    health += value;

                    if (health > 100) {
                        health = 100;
                    }

                    System.out.printf("You healed for %d hp.%n", health - oldHealth);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    System.out.printf("You found %d bitcoins.%n", value);
                    bitcoins += value;
                    break;
                default:
                    health -= value;

                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", action);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", action);
                        System.out.printf("Best room: %d%n", i + 1);
                        return;
                    }
            }
        }

        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n", bitcoins);
        System.out.printf("Health: %d%n", health);
    }
}
