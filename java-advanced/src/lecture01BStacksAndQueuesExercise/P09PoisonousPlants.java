package lecture01BStacksAndQueuesExercise;

import java.util.*;

public class P09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int plantCount = Integer.parseInt(scanner.nextLine());

        int[] plantGmo = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> poisonousPlants = new ArrayDeque<>();

        for (int plant : plantGmo) {
            poisonousPlants.offer(plant);
        }

        int dayCount = 0;

        while (true) {
            List<Integer> indexesToRemove = new ArrayList<>();

            for (int i = 1; i <= plantCount; i++) {
                poisonousPlants.offer(poisonousPlants.poll());

                if (i == plantCount) {
                    continue;
                }

                if (poisonousPlants.getLast() < poisonousPlants.peek()) {
                    indexesToRemove.add(i + 1);
                }
            }

            if (indexesToRemove.isEmpty()) {
                break;
            }

            int loopCount = plantCount;
            plantCount -= indexesToRemove.size();

            for (int i = 1; i <= loopCount; i++) {
                if (indexesToRemove.isEmpty() || i != indexesToRemove.get(0)) {
                    poisonousPlants.offer(poisonousPlants.poll());
                } else {
                    poisonousPlants.poll();
                    indexesToRemove.remove(0);
                }
            }

            dayCount++;
        }

        System.out.println(dayCount);
    }
}