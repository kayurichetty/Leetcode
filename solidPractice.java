
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class solidPractice {
    public static void main(String[] args) {
        /// System.out.println(NameOccurences(new String[] { "m", "a", "m", "y" },
        /// "m"));
        // System.out.println(Arrays.toString(SortList(new String[] { "b", "a", "z", "q"
        /// }, false)));
        // System.out.println(countWords("This is is a is word.","word"));
        // System.out.print(ThresholdCount(new int[]{8, 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4,
        /// 8, 5, 4, 5, 2}, 3));
        // System.out.println(String.valueOf(palindromCheck("Race car")));
       // System.out.println(String.valueOf(maxCharFreq("Programming p is cool")));
        //System.out.println(sumDigits("abc123xyz4"));
        System.out.println(GroupWords(Arrays.asList("apple", "ant", "banana", "ball", "cat")));
    }

    // Q1: Given a list of names, and a target name, calculate how many times the
    // name appears as a decimal fraction (i.e., proportion) of the list
    public static double NameOccurences(String[] list, String target) {
        int size = list.length;
        int duplicates = 0;

        for (String s : list) {
            if (s.equals(target)) {
                duplicates++;
            }
        }

        return (double) (duplicates / (double) size);
    }

    // Q2: Implement logic for a custom comparator of Arrays.sort to sort strings in
    // ascending or descending order depending on a boolean value.
    public static String[] SortList(String[] list, boolean bSort) {
        quicksort(list, 0, list.length - 1, bSort);
        return list;
    }

    public static String[] quicksort(String[] arr, int low, int high, boolean bSort) {
        if (low < high) {
            int pivot = partition(arr, low, high, bSort);
            quicksort(arr, low, pivot - 1, bSort);
            quicksort(arr, pivot + 1, high, bSort);
        }
        return arr;
    }

    public static int partition(String[] arr, int low, int high, boolean bSort) {
        String pivot = arr[high];
        int j = low - 1;

        for (int i = low; i < high; i++) {
            if (bSort) {
                if (arr[i].compareTo(pivot) <= 0) {
                    j++;
                    String temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            } else {
                if (arr[i].compareTo(pivot) >= 0) {
                    j++;
                    String temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        String temp = arr[j + 1];
        arr[j + 1] = arr[high];
        arr[high] = temp;

        return j + 1;

    }

    // Q3 Write logic for a function that determines how many times a given word
    // occurs in a string. Count all case-insensitive matches.
    public static int countWords(String sentence, String word) {
        int count = 0;
        String[] words = sentence.split("[\\s.,!?()]+");
        for (String string : words) {
            if (word.equals(string)) {
                count++;
            }
        }
        return count;
    }

    // Q4 Write a function that returns all numbers in a list that appear equal to
    // or more than a threshold number of times.
    public static List<Integer> ThresholdCount(int[] listNums, int threshold) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : listNums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) >= threshold) {
                res.add(key);
            }
        }

        return res;
    }

    // Q5 Write a function that checks if a string is a palindrome, ignoring case
    // and spaces.
    public static boolean palindromCheck(String string) {
        boolean isPalindrome = false;
        StringBuilder sb = new StringBuilder();

        string = string.toLowerCase();
        string = string.replace(" ", "");

        int j = 0;

        // for (int i = string.length()-1; i >=0; i--) {
        // sb.append(string.charAt(i));
        // }

        // if (string.equals(sb.toString())){
        // isPalindrome=true;
        // }

        for (int i = string.length() - 1; i >= 0; i--) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            j++;
        }
        System.out.println(sb + ":" + string);

        return true;
    }

    // Q6 Write a function that returns the character with the maximum frequency in
    // a string. Ignore spaces and case.
    public static char maxCharFreq(String str) {
        char maxChar = ' ';
        int maxOccurrence = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map.toString());

        for (char key : map.keySet()) {
            if (map.get(key) > maxOccurrence) {
                maxOccurrence = (map.get(key));
                maxChar = key;
            }
        }
        return maxChar;
    }

    //Q7 Write a function that removes duplicate integers from an array and returns a sorted array of unique elements.
    public static int[] removeDuplicates(int[] arr) {
        return Arrays.stream(arr)
                .distinct()
                .sorted()
                .toArray();
    }

    //Q8 Sum of Digits in String
    public static int sumDigits(String string){
        int sum=0;
        List<Character> digits = Arrays.asList('0', '1','2','3','4','5','6','7','8','9');

        for (char c : string.toCharArray()) {
            if (digits.contains(c)){
                System.out.println(c);
                sum+=Integer.valueOf(String.valueOf(c));
            }
        }
        return sum;
    }

    //Q10 Write a function that takes a list of words and groups them into a map based on their starting letter (case-insensitive).
    public static HashMap<Character,List<String>> GroupWords(List<String> list) {
        HashMap<Character,List<String>> map=new HashMap<>();

        for (String string : list) {
            char firstletter=string.charAt(0);
            List<String> temp =(map.getOrDefault(firstletter, new ArrayList<>()));
            temp.add(string);
            map.put(firstletter,temp);
           // System.out.println(map);
        }
     
        return map;
    }
}