import java.util.Scanner;

public class Main {
    private static final String ALPHABET = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose operation: \n1 - Encrypt \n2 - Decrypt \n0 - Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Exit from program.");
                break;
            }

            if (choice != 1 && choice != 2) {
                System.out.println("Wrong input, try again.");
                continue;
            }

            String key;
            while (true) {
                System.out.println("Input key(minimum 7 characters):");
                key = scanner.nextLine().toUpperCase().replaceAll(" ", "");
                if (key.length() >= 7 && key.matches("[А-Я]+")) {
                    break;
                }
                System.out.println("The key must be at least 7 characters long and contain only letters of the Russian alphabet. Try again.");
            }

            System.out.println("Input message:");
            String message = scanner.nextLine().toUpperCase().replaceAll(" ", "");

            if (!message.matches("[А-Я]+")) {
                System.out.println("The message must contain only letters of the Russian alphabet. Try again.");
                continue;
            }

            if (choice == 1) {
                System.out.println("Encrypted message: " + encrypt(message, key));
            } else {
                System.out.println("Decrypted message: " + decrypt(message, key));
            }
        }
    }

    private static String encrypt(String text, String key) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int textIndex = ALPHABET.indexOf(text.charAt(i));
            int keyIndex = ALPHABET.indexOf(key.charAt(i % key.length()));
            int encryptedIndex = (textIndex + keyIndex) % ALPHABET.length();
            encrypted.append(ALPHABET.charAt(encryptedIndex));
        }
        return encrypted.toString();
    }

    private static String decrypt(String text, String key) {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int textIndex = ALPHABET.indexOf(text.charAt(i));
            int keyIndex = ALPHABET.indexOf(key.charAt(i % key.length()));
            int decryptedIndex = (textIndex - keyIndex + ALPHABET.length()) % ALPHABET.length();
            decrypted.append(ALPHABET.charAt(decryptedIndex));
        }
        return decrypted.toString();
    }
}
