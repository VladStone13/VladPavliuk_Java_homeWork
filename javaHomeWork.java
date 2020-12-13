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
        System.out.println(digitalRoot(315));
        ArrayList<Integer> arrInt = new ArrayList<Integer>(Arrays.asList(3, 6, 2, 2, 0, 4, 5));
        System.out.println(countNumbersPairs(arrInt, 5));
        String s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        System.out.println(orderPeople(s));
    }

    public static boolean isSecondBiggerThanFirst(String firstName1, String lastName1, String firstName2, String lastName2) {
        if(lastName2.compareTo(lastName1) < 0) {
            return true;
        }
        else if (lastName2.compareTo(lastName1) == 0) {
            if(firstName2.compareTo(firstName1) < 0) {
                return true;
            }
        }

        return false;
    }

    public static String orderPeople(String str) {
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<String> firstNames = new ArrayList<>();

        String firstName = "";
        String lastName = "";


        boolean ifFirstName = true;

        for (char c:str.toCharArray()) {

            if (c == ':') {
                ifFirstName = !ifFirstName;
                firstNames.add(firstName);
                firstName = "";
            }
            else if (c == ';') {
                ifFirstName = !ifFirstName;
                lastNames.add(lastName);
                lastName = "";
            }
            else if (ifFirstName) {
                firstName += c;
            }
            else {
                lastName += c;
            }
        }

        lastNames.add(lastName);

        for (int i = 0; i < firstNames.size(); ++i) {
            for (int j = 0 ; j < firstNames.size() - 1; ++j) {
                if(isSecondBiggerThanFirst(firstNames.get(j), lastNames.get(j),
                        firstNames.get(j+1), lastNames.get(j+1))) {
                    Collections.swap(lastNames, j, j+1);
                    Collections.swap(firstNames, j, j+1);
                }
            }
        }

        String res = "";
        for (int i = 0; i < firstNames.size(); ++i) {
            res += '(' + lastNames.get(i).toUpperCase() + ", " +
                    firstNames.get(i).toUpperCase() + ")";
        }

        return res;
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
        if (n < 10) {
            return n;
        }

        int sum = 0;
        while (n != 0) {
            sum += (n % 10);
            n /= 10;
        }

        return digitalRoot(sum);
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
