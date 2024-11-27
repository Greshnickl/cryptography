import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class Main {
    String[] chars;
    public static void main(String[] args) {
        Main main = new Main("crypt");

    }

    public Main(String key){
        this.chars = new String[26];
        if (key.isEmpty()){
            for (int i = 65; i <= 90; i++) {
                chars[i - 65] = Character.toString((char) i);
            }
        } else {
            String alphabet = "";
            for (int i = 0; i < key.length(); i++) {
                if (!alphabet.contains(String.valueOf(key.charAt(i)))) {
                    alphabet += String.valueOf(key.charAt(i));
                }
            }
            alphabet = alphabet.toUpperCase();
            for (int i = 0; i < 26; i++) {
                if (!alphabet.contains(Character.toString((char) (i + 65)))){
                    alphabet += Character.toString((char) (i + 65));
                }
            }
            for (int i = 0; i < alphabet.length(); i++) {
                this.chars[i] = "" + alphabet.charAt(i);
            }
        }

    }
    public String encrypt(String s, int key) {
        String input = "";
        String output = "";
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            input += words[i].toUpperCase();
        }
        for (int i = 0; i < input.length(); i++) {
            output +=  chars[(getId(String.valueOf(input.charAt(i))) + key) % 26];
        }
        return output;
    }
    public String decrypt(String s, int key) {
        String input = "";
        String output = "";
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            input += words[i].toUpperCase();
        }
        for (int i = 0; i < input.length(); i++) {
            output +=  chars[(getId(String.valueOf(input.charAt(i))) - key) % 26];
        }
        return output;
    }
    public int getId(String s){
        for (int i = 0; i < chars.length; i++) {
            if (Objects.equals(s, chars[i])){
                return i;
            }
        }
        return -1;
    }

    public boolean checkKey(String key){
        if (key.length() < 8 && StringUtils.isAlphanumeric(key)){
            return false;
        } else {
            return true;
        }
    }

    public String encryptWithTwoKeys(String s, int key1, String key2) {
        if (!checkKey(key2)){
            System.out.println("Key cant have length less that 8 digits, try again");
            return "error";
        }
        String input = "";
        String output = "";
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            input += words[i].toUpperCase();
        }
        for (int i = 0; i < input.length(); i++) {
            output +=  chars[(getId(String.valueOf(input.charAt(i))) + key1) % 26];
        }
        return output;
    }
    public String[] getChars() {
        return this.chars;
    }



}