import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class javaHomeWork {
    public static void main(String args[]) {
        System.out.println(getIntegersFromArray(Arrays.asList(1, 2, "a", "b")));
        System.out.println(getIntegersFromArray(Arrays.asList(1, 2, "a", "b", 0, 15)));
        System.out.println(getIntegersFromArray(Arrays.asList(1, 2, "a", "b", "aasf", "1", "123", 231)));
        System.out.println(firstNonRepeatingLetter("stress"));
        System.out.println(firstNonRepeatingLetter("sTreSS"));
        System.out.println(digitalRoot(227));
        ArrayList<Integer> arrInt = new ArrayList<Integer>(Arrays.asList(3, 6, 2, 2, 0, 4, 5));
        System.out.println(countNumbersPairs(arrInt, 5));
        String s = "Fired:Corwill;Wilfred:Corwill;Barney:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        System.out.println();
    }

    public static String orderPeople(String str) {
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<String> first
    }

    public static List getIntegersFromArray(List data) {
        ArrayList arr = new ArrayList(data);
        arr.removeIf(elem -> elem instanceof String);
        return arr;
    }

    public static char firstNonRepeatingLetter(String str) {
        Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
        for (char c : str.toCharArray()) {
            int count = 0;
            if(counts.containsKey(Character.toUpperCase(c))) {
                count = counts.get(Character.toUpperCase(c));
                counts.put(Character.toUpperCase(c), count + 1);
            }
            else if(counts.containsKey(Character.toLowerCase(c))) {
                count = counts.get(Character.toLowerCase(c));
                counts.put(Character.toLowerCase(c), count + 1);
            }

            counts.put(c, 1);
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return ' ';
    }

    public static int digitalRoot(int n) {
        int root = 0;

        // Loop to do sum while
        // sum is not less than
        // or equal to 9
        while (n > 0 || root > 9)
        {
            if (n == 0) {
                n = root;
                root = 0;
            }

            root += n % 10;
            n /= 10;
        }
        return root;
    }

    public static int countNumbersPairs(ArrayList<Integer> array, int target) {
        int count = 0;
        for(int i = 0; i < array.size(); ++i) {
            for(int j = i + 1; j < array.size(); ++j) {
                if(array.get(i) + array.get(j) == target) {
                    count++;
                }
            }
        }
        return count;
    }



}
