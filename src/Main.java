import java.util.*;

public class Main {
    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
       // WordsChecker wordsChecker = new WordsChecker(text);
       // boolean textA = wordsChecker.hasWord("consectetur");
       // boolean textB = wordsChecker.hasWord("year");

       // System.out.println(textA);
       // System.out.println(textB);

        String[] textAsArray = text.toLowerCase(Locale.ROOT).split("");


        Map<String, Integer> data = new HashMap<>();
        // Удаляем все пробелы
        //String texts = text.replaceAll("\\s", "");
        for (String text : textAsArray) {
            if (Objects.equals(text, "") || check(text)) {
            } else if (data.containsKey(text)) {
                int i = data.get(text);
                i++;
                data.put(text, ++i);
            } else {
                data.put(text, 1);
            }

            //System.out.println(data);
            //System.out.println(texts);


        }
        Collection<Integer> values = data.values();

        int symbolMin = getMin(values);

        int symbolMax = getMax(values);

        List<String> maxInjects = new ArrayList<>();
        List<String> minInjects = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (entry.getValue() == symbolMax) {
                maxInjects.add(entry.getKey());
            } else if (entry.getValue() == symbolMin) {
                minInjects.add(entry.getKey());
            }
        }
        System.out.println("Максимальное колличество " + maxInjects);
        System.out.println("Минимальное колличество " + minInjects);
    }

    private static boolean check(String text) {
        char[] chars = text.toCharArray();
        return !Character.isLetter(chars[0]);

    }

    private static int getMax(Collection<Integer> values) {
        List<Integer> integers = new ArrayList<>(values);
        int symbolMax = integers.get(0);
        for (Integer numbor : integers) {
            if (numbor > symbolMax) {
                symbolMax = numbor;
            }
        }
        return symbolMax;
    }

    private static int getMin(Collection<Integer> values) {
        List<Integer> integers = new ArrayList<>(values);
        int symbolMin = integers.get(0);
        for (Integer numbor : integers) {
            if (numbor < symbolMin) {
                symbolMin = numbor;
            }
        }
        return symbolMin;
    }
}

