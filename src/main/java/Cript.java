import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cript {

    static Map<Character, Integer> charToIntMap = new HashMap<>();

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
        charToIntMap.put('Z', 26);
    }

    static {
        alphabetKey(); // chamado uma única vez quando a classe é carregada
    }

    private static List<Integer> passKey() {
        // k=11, n=14, o=15, w=23, l=12, e=5, d=4, g=7, e=5
        return new ArrayList<>(Arrays.asList(11, 14, 15, 23, 12, 5, 4, 7, 5));
    }

    private static List<Integer> lockKey() {
        // f=6, u=21, t=20, u=21, r=18, e=5
        return new ArrayList<>(Arrays.asList(6, 21, 20, 21, 18, 5));
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
        List<Integer> listKeys = passKey();
        int keyIndex = 0;

        for (char c : text.toUpperCase().toCharArray()) {
            if (!charToIntMap.containsKey(c)) {
                continue;
            }

            int result = charToIntMap.get(c) - listKeys.get(keyIndex) - listKeys.size();
            result = ((((result - 1) % 26) + 26) % 26) + 1;
            decoded += getKeyByValue(result);

            keyIndex++;
            if (keyIndex == listKeys.size()) {
                keyIndex = 0;
            }
        }
        return decoded;
    }

    public static String getLockKey(String name) {
        String encrypted = "";
        List<Integer> listKeys = lockKey();
        int keyIndex = 0;

        for (char c : name.toUpperCase().toCharArray()) {
            if (!charToIntMap.containsKey(c)) {
                continue;
            }

            int result = charToIntMap.get(c) + listKeys.get(keyIndex) + listKeys.size();
            result = ((result - 1) % 26) + 1;
            encrypted += getKeyByValue(result);

            keyIndex++;
            if (keyIndex == listKeys.size()) {
                keyIndex = 0;
            }
        }
        // ASCII dos dois últimos caracteres encriptados = PIN de 4 dígitos
        int len = encrypted.length();
        char last1 = encrypted.charAt(len - 2);
        char last2 = encrypted.charAt(len - 1);
        return "" + (int) last1 + (int) last2;
    }

    public static String encode(String text) {
        String encoded = "";
        List<Integer> listKeys = passKey();
        int keyIndex = 0;

        for (char c : text.toUpperCase().toCharArray()) {
            if (!charToIntMap.containsKey(c)) {
                continue;
            }

            int result = charToIntMap.get(c) + listKeys.get(keyIndex) + listKeys.size();
            result = ((result - 1) % 26) + 1;
            encoded += getKeyByValue(result);

            keyIndex++;
            if (keyIndex == listKeys.size()) {
                keyIndex = 0;
            }
        }
        return encoded;
    }
}
