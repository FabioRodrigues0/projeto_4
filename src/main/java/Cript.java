import java.util.ArrayList;
import java.util.List;

public class Cript {

    public static List<Integer> passkey() {
        String key = new String("knowledge");
        List<Integer> list_keys = new ArrayList<Integer>();

        for (char c : key.toCharArray()) {
            list_keys.add((int) c);
        }

        return list_keys;
    }

    public static String decode(String text) {
        String decoded = new String("");
        List<Integer> list_keys = passkey();
        int key_index = 0;

        for (char c : text.toCharArray()) {
            decoded += (char) ((int) c - list_keys.get(key_index));

            key_index++;
            if (key_index == list_keys.size()) {
                key_index = 0;
            }
        }
        return decoded;
    }

    public static String encode(String text) {
        String encoded = new String("");
        List<Integer> list_keys = passkey();
        int key_index = 0;

        for (char c : text.toCharArray()) {
            encoded += (char) ((int) c + list_keys.get(key_index));

            key_index++;
            if (key_index == list_keys.size()) {
                key_index = 0;
            }
        }
        return encoded;
    }
}
