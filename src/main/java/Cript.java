import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 prompt: o codigo podia ser melhorado como sugeres
 o fazer sem aletar muito o codigo para não estragar a logica dele,
 melhor para não repetir tanto
*/
public class Cript {

    static Map<Character, Integer> charToIntMap = new HashMap<>();

    static {
        for (int i = 0; i < 26; i++) {
            charToIntMap.put((char) ('A' + i), i + 1);
        }
    }

    private static List<Integer> passKey() {
        // k=11, n=14, o=15, w=23, l=12, e=5, d=4, g=7, e=5
        return Arrays.asList(11, 14, 15, 23, 12, 5, 4, 7, 5);
    }

    private static List<Integer> lockKey() {
        // f=6, u=21, t=20, u=21, r=18, e=5
        return Arrays.asList(6, 21, 20, 21, 18, 5);
    }

    private static String cipher(String text, List<Integer> keys, int direction) {
        StringBuilder sb = new StringBuilder();
        int keyIndex = 0;
        for (char c : text.toUpperCase().toCharArray()) {
            if (!charToIntMap.containsKey(c)){
                continue;
            }
            int result = charToIntMap.get(c) + direction * (keys.get(keyIndex) + keys.size());
            result = ((((result - 1) % 26) + 26) % 26) + 1;
            sb.append((char) ('A' + result - 1));
            keyIndex = (keyIndex + 1) % keys.size();
        }
        return sb.toString();
    }

    public static String encode(String text) {
        return cipher(text, passKey(), +1);
    }

    public static String decode(String text) {
        return cipher(text, passKey(), -1);
    }

    public static String getLockKey(String name) {
        String encrypted = cipher(name, lockKey(), +1);
        // ASCII dos dois últimos caracteres encriptados = PIN de 4 dígitos
        int len = encrypted.length();
        char last1 = encrypted.charAt(len - 2);
        char last2 = encrypted.charAt(len - 1);
        return "" + (int) last1 + (int) last2;
    }
}
