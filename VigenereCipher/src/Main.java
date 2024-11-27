import java.util.Scanner;

public class Main {
    private static final String ALPHABET = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию: \n1 - Шифрование \n2 - Дешифрование \n0 - Выход");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Программа завершена.");
                break;
            }

            if (choice != 1 && choice != 2) {
                System.out.println("Некорректный выбор. Попробуйте снова.");
                continue;
            }

            String key;
            while (true) {
                System.out.println("Введите ключ (длина не менее 7):");
                key = scanner.nextLine().toUpperCase().replaceAll(" ", "");
                if (key.length() >= 7 && key.matches("[А-Я]+")) {
                    break;
                }
                System.out.println("Ключ должен быть длиной не менее 7 символов и содержать только буквы русского алфавита. Попробуйте снова.");
            }

            System.out.println("Введите сообщение:");
            String message = scanner.nextLine().toUpperCase().replaceAll(" ", "");

            if (!message.matches("[А-Я]+")) {
                System.out.println("Сообщение должно содержать только буквы русского алфавита. Попробуйте снова.");
                continue;
            }

            if (choice == 1) {
                System.out.println("Зашифрованное сообщение: " + encrypt(message, key));
            } else {
                System.out.println("Расшифрованное сообщение: " + decrypt(message, key));
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
