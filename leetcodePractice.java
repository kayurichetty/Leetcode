
import java.util.ArrayList;
import java.util.HashMap;

public class leetcodePractice {
    public static void main(String[] args) {
        // int[] nums = { 3, 6, 10, 1, 8, 9, 9, 8, 9 };
        // System.out.println(maxAscendingSum(nums));
        // System.out.println(areAlmostEqual("bank", "kanb"));
        // int[] nums = {2,3,4,6};
        // System.out.println(tupleSameProduct(nums));
        // int[][] queries = {{0,1},{1,2},{2,2},{3,4},{4,5}};
        // System.out.println(java.util.Arrays.toString(queryResults(4, queries)));
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }

    public static int maxAscendingSum(int[] nums) {
        int Sum = 0;
        int highest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if ((i + 1 == nums.length - 1) && (nums[i] < nums[i + 1])) {
                Sum += nums[i] + nums[i + 1];
            } else if (nums[i] < nums[i + 1]) {
                Sum += nums[i];
            } else if (i > 0) {
                if ((nums[i] >= nums[i + 1]) && (nums[i - 1] < nums[i])) {
                    Sum += nums[i];
                    if (Sum > highest) {
                        highest = Sum;
                    }
                    Sum = 0;
                } else {
                    Sum = 0;
                }
            } else {
                Sum = 0;
            }

            if (Sum > highest) {
                highest = Sum;
            }
        }
        if (highest == 0) {
            highest = nums[0];
        }
        return highest;
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        String newS1 = "";

        if (s1.equals(s2)) {
            return true;
        } else if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length() - 1; i++) {
            for (int index = i + 1; index < s1.length(); index++) {
                System.out.println("Swapping: " + s1.charAt(i) + " with " + s1.charAt(index));
                if (i == 0) {
                    newS1 = s1.charAt(index) + s1.substring(i + 1, index) + s1.substring(i, i + 1)
                            + s1.substring(index + 1);
                } else {
                    newS1 = s1.substring(0, i) + s1.charAt(index) + s1.substring(i + 1, index) + s1.substring(i, i + 1)
                            + s1.substring(index + 1);
                }

                // System.out.println(newS1);
                if (newS1.equals(s2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int tupleSameProduct(int[] nums) {
        int count = 0;
        int productA = 0;
        int productB = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                productA = nums[i] * nums[j];
            }
        }
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = 0; j < nums.length; j++) {
        // for (int k = 0; k < nums.length; k++) {
        // for (int l = 0; l < nums.length; l++) {
        // if (i!=j && i!=k && i!=l && j!=k && j!=l && k!=l){
        // productA = nums[i]*nums[j];
        // productB = nums[k]*nums[l];
        // if (productA == productB){
        // count++;
        // }
        // }
        // }
        // }
        // }
        // }
        return count;
    }

    public static int[] queryResults(int limit, int[][] queries) {
        int[] colours = new int[limit + 1];
        ArrayList<Integer> arrInt = new ArrayList<>();
        HashMap<Integer, Integer> colourCount = new HashMap<>();

        for (int[] query : queries) {
            int index = query[0];
            int colour = query[1];

            if (colours[index] != 0) {
                colourCount.put(colours[index], colourCount.get(colours[index]) - 1);
                if (colourCount.get(colours[index]) == 0) {
                    colourCount.remove(colours[index]);
                }
            }

            colours[index] = colour;
            colourCount.put(colour, colourCount.getOrDefault(colour, 0) + 1);

            arrInt.add(colourCount.size());
        }

        int[] result = new int[arrInt.size()];
        for (int i = 0; i < arrInt.size(); i++) {
            result[i] = arrInt.get(i);
        }
        return result;
    }

    public static String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s=s.replaceFirst(part, "");
        }
        return s;
    }

}
