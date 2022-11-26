package lecture01BWorkingWithAbstractionExercise.greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] treasureChest = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);

        for (int i = 0; i < treasureChest.length; i += 2) {
            String itemName = treasureChest[i];
            long amount = Long.parseLong(treasureChest[i + 1]);

            Item item = createItem(itemName, amount);

            if (item.getItemType() == null) {
                continue;
            }

            bag.put(item);
        }

        System.out.println(bag);
    }

    private static Item createItem(String itemName, long amount) {
        ItemType itemType = null;

        if (itemName.length() == 3) {
            itemType = ItemType.CASH;
        } else if (itemName.toLowerCase().endsWith("gem")) {
            itemType = ItemType.GEM;
        } else if (itemName.equalsIgnoreCase("gold")) {
            itemType = ItemType.GOLD;
        }

        return new Item(itemType, itemName, amount);
    }
}