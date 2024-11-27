import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Выберите способ ввода данных:");
        System.out.println("1 - Ввести данные с клавиатуры");
        System.out.println("2 - Сгенерировать случайные данные");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String Li_1;
        String SBlocksResult;

        if (choice == 1) {
            System.out.println("Введите L(i-1) (32 бита):");
            Li_1 = scanner.nextLine();
            if (!isValidBinary(Li_1, 32)) {
                System.out.println("Ошибка: L(i-1) должен содержать ровно 32 бита.");
                return;
            }

            System.out.println("Введите результат работы S-блоков (32 бита):");
            SBlocksResult = scanner.nextLine();
            if (!isValidBinary(SBlocksResult, 32)) {
                System.out.println("Ошибка: результат S-блоков должен содержать ровно 32 бита.");
                return;
            }
        } else {
            Li_1 = generateRandomBinary(32, random);
            SBlocksResult = generateRandomBinary(32, random);
            System.out.println("Сгенерированный L(i-1): " + Li_1);
            System.out.println("Сгенерированный результат S-блоков: " + SBlocksResult);
        }

        String Ri = xorBinaryStrings(Li_1, SBlocksResult);
        System.out.println("R(i) = " + Ri);
    }

    private static boolean isValidBinary(String input, int length) {
        return input.matches("[01]+") && input.length() == length;
    }

    private static String generateRandomBinary(int length, Random random) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < length; i++) {
            binary.append(random.nextInt(2));
        }
        return binary.toString();
    }

    private static String xorBinaryStrings(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            char bit1 = str1.charAt(i);
            char bit2 = str2.charAt(i);
            result.append(bit1 == bit2 ? '0' : '1');
        }
        return result.toString();
    }
}
