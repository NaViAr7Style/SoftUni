package lecture04CForLoopAdditionalExercises;

import java.util.Scanner;

public class P02Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int doctorCount = 7;
        int treatedPatients = 0;
        int untreatedPatients = 0;

        for (int i = 1; i <= days; i++) {
            int patientsCount = Integer.parseInt(scanner.nextLine());

            if (i % 3 == 0 && untreatedPatients > treatedPatients) {
                doctorCount++;
            }

            if (patientsCount <= doctorCount) {
                treatedPatients += patientsCount;
            } else {
                treatedPatients += doctorCount;
                untreatedPatients += patientsCount - doctorCount;
            }
        }

        System.out.printf("Treated patients: %d.%n", treatedPatients);
        System.out.printf("Untreated patients: %d.%n", untreatedPatients);
    }
}
