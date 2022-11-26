package lecture05BListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> curriculum = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("course start")) {
            String[] commandLine = input.split(":");
            String command = commandLine[0];
            String lessonTitle = commandLine[1];
            String lessonExercise = lessonTitle + "-Exercise";

            switch (command) {
                case "Add":
                    if (!curriculum.contains(lessonTitle)) {
                        curriculum.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandLine[2]);
                    if (!curriculum.contains(lessonTitle)) {
                        curriculum.add(index, lessonTitle);
                    }
                    break;
                case "Remove":
                    curriculum.remove(lessonTitle);
                    curriculum.remove(lessonExercise);
                    break;
                case "Swap":
                    String lessonToSwap = commandLine[2];
                    String swapExercise = lessonToSwap + "-Exercise";

                    if (curriculum.contains(lessonTitle) && curriculum.contains(lessonToSwap)) {
                        int firstIndex = curriculum.indexOf(lessonTitle);
                        int secondIndex = curriculum.indexOf(lessonToSwap);
                        curriculum.set(firstIndex, lessonToSwap);
                        curriculum.set(secondIndex, lessonTitle);

                        if (curriculum.contains(lessonExercise) && curriculum.contains(swapExercise)) {
                            curriculum.set(firstIndex + 1, swapExercise);
                            curriculum.set(secondIndex + 1, lessonExercise);
                        } else if (curriculum.contains(lessonExercise)) {
                            curriculum.remove(lessonExercise);
                            int lessonIndex = curriculum.indexOf(lessonTitle);
                            curriculum.add(lessonIndex + 1, lessonExercise);
                        } else if (curriculum.contains(swapExercise)) {
                            curriculum.remove(swapExercise);
                            int swapIndex = curriculum.indexOf(lessonToSwap);
                            curriculum.add(swapIndex + 1, swapExercise);
                        }
                    }
                    break;
                case "Exercise":
                    if (curriculum.contains(lessonTitle)) {
                        if (!curriculum.contains(lessonExercise)) {
                            int indexOfLesson = curriculum.indexOf(lessonTitle);
                            curriculum.add(indexOfLesson + 1, lessonExercise);
                        }
                    } else {
                        curriculum.add(lessonTitle);
                        curriculum.add(lessonExercise);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < curriculum.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, curriculum.get(i));
        }
    }
}
