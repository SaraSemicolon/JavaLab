package Lab4;

import java.util.ArrayList;
import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        String s = "  dcssdhhhfvdsfdoooopq";
        System.out.println("--- Check whether a string is palindrome or not. ---");
        System.out.println(isPalindrome(s));

        System.out.println("--- Remove all leading whitespaces from a string. ---");
        System.out.println(s.trim());

        System.out.println("--- Count the occurrences of a character in a string. ---");
        System.out.println(countTheOccurrencesOfACharacter(s, 'a'));

        System.out.println("--- Remove duplicate characters from a string. ---");
        System.out.println(removeDuplicateCharacters(s));

        System.out.println("--- Display the words that appear more than twice in a string. ---");
        System.out.println(Arrays.toString(appearMoreThanTwice(s)));

        System.out.println("--- Get the third occurrences of a character in a string ---");
        System.out.println(getTheThirdOccurrences(s,'h'));

        System.out.println("---  Determine the minimum occurring characters in a string ---");
        System.out.println(Arrays.toString(DetermineTheMinimumOccurring(s)));

        System.out.println("---  Determine the maximum occurring characters in a string ---");
        System.out.println(Arrays.toString(DetermineTheMaximumOccurring(s)));
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        return true;
    }

    public static int countTheOccurrencesOfACharacter(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == c)
                count++;
        return count;
    }

    public static String removeDuplicateCharacters(String s) {
        StringBuffer st = new StringBuffer(s);
        for (int i = 0; i < st.length() - 1; i++)
            for (int j = i + 1; j < st.length(); ) {
                if (st.charAt(i) == st.charAt(j))
                    st.deleteCharAt(j);
                else
                    j++;
            }
        return st.toString();
    }

    public static char[] appearMoreThanTwice(String s)
    {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (countTheOccurrencesOfACharacter(s, c) > 2 && !list.contains(c))
                list.add(c);
        }

        char[] result = new char[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }

    public static int getTheThirdOccurrences(String s, char c) {
        int count = 0;
        for (int i = 0 ; i < s.length() ; i++)
        {
            if (s.charAt(i) == c)
                count++;
            if(count == 3)
                return i;
        }
        return -1;
    }

    public static char [] DetermineTheMinimumOccurring(String s)
    {
        ArrayList<Character> list = new ArrayList<>();
        int minCount = countTheOccurrencesOfACharacter(s, s.charAt(0));
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int currentCount = countTheOccurrencesOfACharacter(s, c);

            if (currentCount < minCount)
            {
                list.clear();
                list.add(c);
                minCount = currentCount;
            }
            else if (currentCount == minCount && !list.contains(c))
            {
                list.add(c);
            }
        }

        char [] result = new char[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static char [] DetermineTheMaximumOccurring(String s)
    {
        ArrayList<Character> list = new ArrayList<>();
        int maxCount = countTheOccurrencesOfACharacter(s, s.charAt(0));
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int currentCount = countTheOccurrencesOfACharacter(s, c);

            if (currentCount > maxCount)
            {
                list.clear();
                list.add(c);
                maxCount = currentCount;
            }
            else if (currentCount == maxCount && !list.contains(c))
            {
                list.add(c);
            }
        }

        char [] result = new char[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}