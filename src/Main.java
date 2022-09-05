import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static final String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
            " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
            " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris" +
            " nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in " +
            "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla " +
            "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
            "culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        char[] symbols = text.toLowerCase(Locale.ROOT).toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        //Если мин и макс значений будет несколько:
        Map<Character, Integer> maxPoints = new HashMap<>();
        Map<Character, Integer> minPoints = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            int value = 0;
            for (int j = 0; j < text.length(); j++) {
                if (symbols[i] == symbols[j]) {
                    ++value;
                }
            }
            if (symbols[i] != ' ') {
                map.put(symbols[i], value);
            }

        }
        System.out.println(map);
        Map.Entry<Character, Integer> maxSymbol = getMaxSymbol(map, maxPoints);
        Map.Entry<Character, Integer> minSymbol = getMinSymbol(map, minPoints);

        System.out.println("Чаще всего встречается буква " + maxSymbol
                + " . В таких же количествах в тексте встречаются буквы: " + maxPoints);
        System.out.println("Реже всего встречается буква " + minSymbol
                + " . В таких же количествах в тексте встречаются буквы: " + minPoints);
    }

    public static Map.Entry<Character, Integer> getMaxSymbol(Map<Character, Integer> map, Map<Character, Integer> maxPoints) {
        int maxCount = -1;
        Map.Entry<Character, Integer> maxResult = null;
        for (Map.Entry<Character, Integer> s : map.entrySet()) {
            if (s.getValue() > maxCount) {
                maxResult = s;
                maxCount = s.getValue();
            }
        }
        for (Map.Entry<Character, Integer> s : map.entrySet()) {
            if (maxResult.getValue() == s.getValue()) {
                maxPoints.put(s.getKey(), s.getValue());
            }
        }
        return maxResult;
    }

    public static Map.Entry<Character, Integer> getMinSymbol(Map<Character, Integer> map, Map<Character, Integer> minPoints) {
        int minCount = Integer.MAX_VALUE;
        Map.Entry<Character, Integer> minResult = null;
        for (Map.Entry<Character, Integer> s : map.entrySet()) {
            if (minCount > s.getValue()) {
                minResult = s;
                minCount = s.getValue();
            }
        }
        for (Map.Entry<Character, Integer> s : map.entrySet()) {
            if (minResult.getValue() == s.getValue()) {
                minPoints.put(s.getKey(), s.getValue());
            }
        }
        return minResult;
    }

}