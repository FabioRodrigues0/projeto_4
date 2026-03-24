import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.String;
import java.lang.Character;

public class Cript {

    static Map<Character, Integer> charToIntMap = new HashMap<>();

    private static List<Integer> passkey() {
        Map<Character, Integer> passMap = new HashMap<>();
        passMap.put('k', 11);
        passMap.put('o', 15);
        passMap.put('w', 23);
        passMap.put('n', 14);
        passMap.put('e', 5);
        passMap.put('d', 4);
        passMap.put('g', 7);
        passMap.put('a', 1);
        passMap.put('v', 22);

        return new ArrayList<>(passMap.values());
    }

    private static void alphabetKey() {
        charToIntMap.put('A', 1);
        charToIntMap.put('B', 2);
        charToIntMap.put('C', 3);
        charToIntMap.put('D', 4);
        charToIntMap.put('E', 5);
        charToIntMap.put('F', 6);
        charToIntMap.put('G', 7);
        charToIntMap.put('H', 8);
        charToIntMap.put('I', 9);
        charToIntMap.put('J', 10);
        charToIntMap.put('K', 11);
        charToIntMap.put('L', 12);
        charToIntMap.put('M', 13);
        charToIntMap.put('N', 14);
        charToIntMap.put('O', 15);
        charToIntMap.put('P', 16);
        charToIntMap.put('Q', 17);
        charToIntMap.put('R', 18);
        charToIntMap.put('S', 19);
        charToIntMap.put('T', 20);
        charToIntMap.put('U', 21);
        charToIntMap.put('V', 22);
        charToIntMap.put('W', 23);
        charToIntMap.put('X', 24);
        charToIntMap.put('Y', 25);
    }

    private static char getKeyByValue(int value) {
        for (Map.Entry<Character, Integer> entry : charToIntMap.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static String decode(String text) {
        String decoded = "";
        List<Integer> list_keys = passkey();
        int key_index = 0;
        alphabetKey();

        for (char c : text.toCharArray()) {
            decoded += getKeyByValue(
                charToIntMap.get(c).intValue() - list_keys.get(key_index) - 9
            );

            key_index++;
            if (key_index == list_keys.size()) {
                key_index = 0;
            }
        }
        return decoded;
    }

    public static String encode(String text) {
        String encoded = "";
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
