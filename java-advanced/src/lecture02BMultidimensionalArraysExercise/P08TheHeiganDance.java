package lecture02BMultidimensionalArraysExercise;

import java.util.*;

public class P08TheHeiganDance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int playerRow = 7;
        int playerCol = 7;

        int playerHealth = 18500;
        double heiganHealth = 3000000;
        double playerDamage = Double.parseDouble(scanner.nextLine());
        String lastSpell = "";
        while (true) {

            if (playerHealth > 0) {
                heiganHealth -= playerDamage;
            }

            if (lastSpell.equals("Cloud")) {
                playerHealth -= 3500;
            }

            if (heiganHealth <= 0 || playerHealth <= 0) {
                break;
            }

            boolean wasHit = false;

            String[] input = scanner.nextLine().split(" ");

            String spell = input[0];
            int spellRow = Integer.parseInt(input[1]);
            int spellCol = Integer.parseInt(input[2]);

            if (isInDamageArea(spellRow, spellCol, playerRow, playerCol)) {
                if (!isInDamageArea(spellRow, spellCol, playerRow - 1, playerCol) && isNotWall(playerRow - 1)) {
                    playerRow--;
                } else if (!isInDamageArea(spellRow, spellCol, playerRow, playerCol + 1) && isNotWall(playerCol + 1)) {
                    playerCol++;
                } else if (!isInDamageArea(spellRow, spellCol, playerRow + 1, playerCol) && isNotWall(playerRow + 1)) {
                    playerRow++;
                } else if (!isInDamageArea(spellRow, spellCol, playerRow, playerCol - 1) && isNotWall(playerCol - 1)) {
                    playerCol--;
                } else {
                    if (spell.equals("Cloud")) {
                        playerHealth -= 3500;
                        wasHit = true;
                    } else if (spell.equals("Eruption")) {
                        playerHealth -= 6000;
                        wasHit = true;
                    }
                }

                if (wasHit) {
                    lastSpell = spell;
                } else {
                    lastSpell = "";
                }
            }
        }

        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";
        String heiganState = heiganHealth <= 0 ? "Heigan: Defeated!" : String.format("Heigan: %.2f", heiganHealth);
        String playerState = playerHealth <= 0 ? String.format("Player: Killed by %s", lastSpell) :
                String.format("Player: %d", playerHealth);
        String playerEndCoordinates = String.format("Final position: %d, %d", playerRow, playerCol);

        System.out.println(heiganState);
        System.out.println(playerState);
        System.out.println(playerEndCoordinates);
    }

    private static boolean isNotWall(int moveCell) {
        return moveCell >= 0 && moveCell < 15;
    }

    private static boolean isInDamageArea(int hitRow, int hitCol, int positionRow, int positionCol) {
        return ((hitRow - 1 <= positionRow && positionRow <= hitRow + 1)
                && (hitCol - 1 <= positionCol && positionCol <= hitCol + 1));
    }
}