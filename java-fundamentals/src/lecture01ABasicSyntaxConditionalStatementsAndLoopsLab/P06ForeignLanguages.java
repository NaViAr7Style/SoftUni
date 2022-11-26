package lecture01ABasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class P06ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();

        String language = "";

        switch (country) {
            case "England":
            case "USA":
                language = "English";
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                language = "Spanish";
                break;
            default:
                language = "unknown";
        }

//        String language = switch (country) {
//            case "England", "USA" -> "English";
//            case "Spain", "Argentina", "Mexico" -> "Spanish";
//            default -> "unknown";
//        };

        System.out.println(language);
    }
}
