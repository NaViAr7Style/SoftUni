package lecture04BMethodsExercise;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P11ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("end")) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "exchange":
                    int index = Integer.parseInt(command[1]);
                    numArray = splitArray(numArray, index);
                    break;
                case "max":
                    maxElement(numArray, command[1]);
                    break;
                case "min":
                    minElement(numArray, command[1]);
                    break;
                case "first":
                    int count = Integer.parseInt(command[1]);
                    firstNumbers(numArray, count, command[2]);
                    break;
                case "last":
                    int numCount = Integer.parseInt(command[1]);
                    lastNumbers(numArray, numCount, command[2]);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(Arrays.toString(numArray));
    }

    public static int[] splitArray(int[] intArray, int index) {
        if (index < 0 || intArray.length <= index) {
            System.out.println("Invalid index");
            return intArray;
        }

        String result = "";

        for (int i = index + 1; i < intArray.length; i++) {
            result += intArray[i] + " ";
        }
        for (int i = 0; i <= index; i++) {
            result += intArray[i] + " ";
        }

        intArray = Arrays.stream(result.split(" ")).mapToInt(Integer::parseInt).toArray();

        return intArray;
    }

    public static void maxElement(int[] intArray, String numType) {
        int maxValue = Integer.MIN_VALUE;
        int index = -1;

        if (numType.equals("even")) {
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] % 2 == 0 && intArray[i] >= maxValue) {
                    maxValue = intArray[i];
                    index = i;
                }
            }
        } else if (numType.equals("odd")) {
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] % 2 == 1 && intArray[i] >= maxValue) {
                    maxValue = intArray[i];
                    index = i;
                }
            }
        }

        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }

    public static void minElement(int[] intArray, String numType) {
        int minValue = Integer.MAX_VALUE;
        int index = -1;

        if (numType.equals("even")) {
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] % 2 == 0 && intArray[i] <= minValue) {
                    minValue = intArray[i];
                    index = i;
                }
            }
        } else if (numType.equals("odd")) {
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] % 2 == 1 && intArray[i] <= minValue) {
                    minValue = intArray[i];
                    index = i;
                }
            }
        }

        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }

    public static void firstNumbers(int[] intArray, int count, String numType) {
        if (count > intArray.length) {
            System.out.println("Invalid count");
            return;
        }

        int[] result = new int[count];
        int indexToPopulate = 0;

        if (numType.equals("even")) {
            for (int i = 0; i < intArray.length; i++) {
                if (indexToPopulate == count) {
                    break;
                }
                if (intArray[i] % 2 == 0) {
                    result[indexToPopulate] = intArray[i];
                    indexToPopulate++;
                }
            }
        } else if (numType.equals("odd")) {
            for (int i = 0; i < intArray.length; i++) {
                if (indexToPopulate == count) {
                    break;
                }
                if (intArray[i] % 2 == 1) {
                    result[indexToPopulate] = intArray[i];
                    indexToPopulate++;
                }
            }
        }

        int[] finalResult = new int[indexToPopulate];
        System.arraycopy(result, 0, finalResult, 0, finalResult.length);

        System.out.println(Arrays.toString(finalResult));
    }

    public static void lastNumbers(int[] intArray, int count, String numType) {
        if (count > intArray.length) {
            System.out.println("Invalid count");
            return;
        }

        int[] result = new int[count];
        int indexToPopulate = 0;

        if (numType.equals("even")) {
            for (int i = intArray.length - 1; i >= 0; i--) {
                if (indexToPopulate == count) {
                    break;
                }
                if (intArray[i] % 2 == 0) {
                    result[indexToPopulate] = intArray[i];
                    indexToPopulate++;
                }
            }
        } else if (numType.equals("odd")) {
            for (int i = intArray.length - 1; i >= 0; i--) {
                if (indexToPopulate == count) {
                    break;
                }
                if (intArray[i] % 2 == 1) {
                    result[indexToPopulate] = intArray[i];
                    indexToPopulate++;
                }
            }
        }

        int[] temp = new int[indexToPopulate];

        System.arraycopy(result, 0, temp, 0, temp.length);

        int[] finalResult = new int[indexToPopulate];

        for (int i = 0; i < finalResult.length; i++) {
            finalResult[i] = temp[temp.length - i - 1];
        }

        System.out.println(Arrays.toString(finalResult));
    }
}
