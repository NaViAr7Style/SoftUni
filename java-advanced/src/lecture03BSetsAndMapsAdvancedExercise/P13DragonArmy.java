package lecture03BSetsAndMapsAdvancedExercise;

import java.util.*;

public class P13DragonArmy {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<Integer>>> dragonArmy = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String[] tokens = getValues(input);

            String type = input[0];
            String name = input[1];
            int damage = Integer.parseInt(tokens[2]);
            int health = Integer.parseInt(tokens[3]);
            int armor = Integer.parseInt(tokens[4]);

            dragonArmy.putIfAbsent(type, new TreeMap<>());
            dragonArmy.get(type).put(name, new ArrayList<>());
            dragonArmy.get(type).get(name).add(damage);
            dragonArmy.get(type).get(name).add(health);
            dragonArmy.get(type).get(name).add(armor);
        }

        for (var type : dragonArmy.entrySet()) {
            List<String> dragons = new ArrayList<>();
            int totalDamage = 0;
            int totalHealth = 0;
            int totalArmor = 0;

            for (var dragon : type.getValue().entrySet()) {
                int currentDamage = dragon.getValue().get(0);
                int currentHealth = dragon.getValue().get(1);
                int currentArmor = dragon.getValue().get(2);

                totalDamage += currentDamage;
                totalHealth += currentHealth;
                totalArmor += currentArmor;

                String currentDragon = String.format("-%s -> damage: %d, health: %d, armor: %d", dragon.getKey(), currentDamage, currentHealth, currentArmor);

                dragons.add(currentDragon);
            }

            double averageDamage = totalDamage * 1.0 / type.getValue().size();
            double averageHealth = totalHealth * 1.0 / type.getValue().size();
            double averageArmor = totalArmor * 1.0 / type.getValue().size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type.getKey(),averageDamage, averageHealth, averageArmor);

            for (String dragon : dragons) {
                System.out.println(dragon);
            }
        }
    }

    private static String[] getValues(String[] input) {

        Set<Integer> indexes = new HashSet<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("null")) {
                indexes.add(i);
            }
        }

        for (int index : indexes) {
            if (index == 2) {
                input[index] = "45";
            } else if (index == 3) {
                input[index] = "250";
            } else if (index == 4) {
                input[index] = "10";
            }
        }

        return input;
    }
}