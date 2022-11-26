package lecture01ABasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class P05MonthPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        String month = "";

        switch (input) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                month = "Error!";
        }

//        String month = switch (input) {
//            case 1 -> "January";
//            case 2 -> "February";
//            case 3 -> "March";
//            case 4 -> "April";
//            case 5 -> "May";
//            case 6 -> "June";
//            case 7 -> "July";
//            case 8 -> "August";
//            case 9 -> "September";
//            case 10 -> "October";
//            case 11 -> "November";
//            case 12 -> "December";
//            default -> "Error!";
//        };

        System.out.println(month);
    }
}