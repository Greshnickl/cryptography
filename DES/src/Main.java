import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Choose method of input data:");
        System.out.println("1 - Input from keyboard");
        System.out.println("2 - Generate random data");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String Li_1;
        String SBlocksResult;

        if (choice == 1) {
            System.out.println("Input L(i-1) (32 bits):");
            Li_1 = scanner.nextLine();
            if (!isValidBinary(Li_1, 32)) {
                System.out.println("Error: L(i-1) must contains 32 bits.");
                return;
            }

            System.out.println("Input S-block (32 bits):");
            SBlocksResult = scanner.nextLine();
            if (!isValidBinary(SBlocksResult, 32)) {
                System.out.println("Error: S-block must contains 32 bits.");
                return;
            }
        } else {
            Li_1 = generateRandomBinary(32, random);
            SBlocksResult = generateRandomBinary(32, random);
            System.out.println("Generated L(i-1): " + Li_1);
            System.out.println("Generated S-block: " + SBlocksResult);
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
