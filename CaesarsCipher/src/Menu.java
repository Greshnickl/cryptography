import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        console();

    }


    public static void console(){
        boolean m = true;
        String s = "";
        int k = 0;
        String k2 = "";
        Scanner sc = new Scanner(System.in);
        Main main = new Main("");
        while (m){
            System.out.println("""
                    Choose operation:
                    1.Encrypt string
                    2.Decrypt string
                    3.Encrypt string with 2 keys
                    4.Exit
                    >>>
                    """);
            String input =  sc.nextLine();
            switch (input){
                case "1":
                    System.out.println("Enter line for encrypting");
                    s = sc.nextLine();
                    System.out.println("Enter key for encrypting");
                    k = sc.nextInt();
                    System.out.println("Encrypted string: " + main.encrypt(s, k) + "\n \n");
                    console();
                    break;
                case "2":
                    System.out.println("Enter line for decrypting");
                    s = sc.nextLine();
                    System.out.println("Enter key for decrypting");
                    k = sc.nextInt();
                    System.out.println("Decrypted string: " + main.decrypt(s, k) + "\n \n");
                    console();
                    break;
                case "3":
                    System.out.println("Enter line for encrypting with 2 keys");
                    s = sc.nextLine();
                    System.out.println("Enter first key");
                    k = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter second key");
                    k2 = sc.nextLine();
                    main = new Main(k2);
                    if (main.encryptWithTwoKeys(s, k, k2) != "error"){
                        System.out.println("Encrypted line is: "+main.encryptWithTwoKeys(s, k, k2));
                    } else {
                        console();
                    }
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input" + "\n \n");
                    console();
                    break;
            }
        }
    }
}
