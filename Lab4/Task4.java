package Lab4;

import java.util.Arrays;

public class Task4
{
    public static void main(String[] args)
    {
        String[] strings = {"A.java", "Program.cpp", "test", "Code.java", "test", "Java"};

        System.out.println("--- 1. Find the string with the longest length ---");
        System.out.println(findLongestString(strings));

        System.out.println("\n--- 2. Find the most frequent string ---");
        System.out.println(findMostFrequentString(strings));

        System.out.println("\n--- 3. Reverse the strings that have even lengths ---");
        reverseEvenLengthStrings(strings);
        System.out.println(Arrays.toString(strings));

        System.out.println("\n--- 4. Find the string with the maximum occurrence of a character ('a') ---");
        System.out.println(findStringWithMaxCharacterOccurrence(strings, 'a'));

        System.out.println("\n--- 5. Count the strings that contain a specified file extension (e.g., .java) ---");
        System.out.println(countStringsWithExtension(strings, ".java"));

        System.out.println("\n--- 6. Count non-repeated characters of each string (2D Array) ---");
        int[][] nonRepeatedCounts = countNonRepeatedCharacters(strings);
        for (int[] row : nonRepeatedCounts) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static String findLongestString(String[] arr) {
        if (arr == null || arr.length == 0) return null;
        String longest = arr[0];
        for (String s : arr) {
            if (s.length() > longest.length()) {
                longest = s;
            }
        }
        return longest;
    }

    public static String findMostFrequentString(String[] arr) {
        if (arr == null || arr.length == 0) return null;
        String mostFrequent = arr[0];
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = arr[i];
            }
        }
        return mostFrequent;
    }

    public static void reverseEvenLengthStrings(String[] arr) {
        if (arr == null) return;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() % 2 == 0) {
                arr[i] = new StringBuilder(arr[i]).reverse().toString();
            }
        }
    }

    public static String findStringWithMaxCharacterOccurrence(String[] arr, char target) {
        if (arr == null || arr.length == 0) return null;
        String bestString = arr[0];
        int maxOccurrences = -1;

        for (String s : arr) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == target) {
                    count++;
                }
            }
            if (count > maxOccurrences) {
                maxOccurrences = count;
                bestString = s;
            }
        }
        return bestString;
    }

    public static int countStringsWithExtension(String[] arr, String extension) {
        if (arr == null) return 0;
        int count = 0;
        for (String s : arr) {
            if (s.endsWith(extension)) {
                count++;
            }
        }
        return count;
    }

    public static int[][] countNonRepeatedCharacters(String[] arr) {
        if (arr == null) return new int[0][0];

        int[][] result = new int[arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            int nonRepeatedCount = 0;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                int count = 0;
                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(k) == c) {
                        count++;
                    }
                }
                if (count == 1) {
                    nonRepeatedCount++;
                }
            }

            result[i][0] = s.length();
            result[i][1] = nonRepeatedCount;
        }
        return result;
    }
}