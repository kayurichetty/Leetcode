import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

//import javax.swing.tree.TreeNode;

public class amazonPractice {
    public static void main(String[] args) {
       // System.out.println(firstUniqChar("leetcode"));
       // System.out.println(lengthOfLongestSubstring("nfpdmpi"));
      // System.out.println(isAnagram("anagram","nagaram"));
    //merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    // TreeNode node1 = new amazonPractice.TreeNode(1);
    // TreeNode node3 = new amazonPractice.TreeNode(3);
    // TreeNode root = new amazonPractice.TreeNode(2, node1, node3);

    // System.out.println(isValidBST(root));
    //System.out.println(reverseWords("a b    c"));
    //System.out.println(isBracketValid("()"));
    System.out.println(new String[]{"2","1","+","3","*"});
    }

    public static boolean isValidBST(TreeNode root) {
       Stack<TreeNode> stack=new Stack<>();
       TreeNode current=root;
       Integer prev=null;  

       while (current!=null || !stack.isEmpty()){ //current has a val & stack has values
        while (current!=null){
            stack.push(current); //pushes tree onto stack (2,1,3)
            current=current.left;
        }
        current=stack.pop();
          
        if (prev != null && current.val <= prev) {
                return false;
            }
            prev = current.val;
            // Go right
            current = current.right;
       }

        return true;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static int firstUniqChar(String s) {
                for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (s.indexOf(c)==s.lastIndexOf(c)){
                return i;
            }
        }
        
        return -1;
    }

    //String builder is mutable while strings create new strings in memeory when there are changes
     public static int lengthOfLongestSubstring(String s) {
        int longest=0;
        
        StringBuilder substring=new StringBuilder();
          for (int i = 0; i <s.length(); i++) {
            char c=s.charAt(i);
            int index= substring.indexOf(String.valueOf(c));
            
            if (index!=-1){ //slide window
                substring.delete(0, index+1);
            }

            substring.append(c);

            if (substring.length()>longest){
            longest = substring.length();
            }
        }
        return longest;
    }

     public static boolean isAnagram(String s, String t) {      
        if (s.length()!=t.length()){
            return false;
        }
        else{
            HashMap<Character,Integer> mapS=new HashMap<>();
            HashMap<Character,Integer> mapT=new HashMap<>();

             for (char c : s.toCharArray()) {
                 mapS.put(c, mapS.getOrDefault(c, 0) + 1);
              }
              for (char c : t.toCharArray()) {
                 mapT.put(c, mapT.getOrDefault(c, 0) + 1);
              }

            if (mapS.equals(mapT)){
                return true;
            }
        }
        return false;
    }

     public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int counter=m;
        for (int i : nums2) {
            nums1[counter]=i;
            counter++;
        }
        //use quicksort to sort
       
      // Collections.sort(nums1);
      int[] arr=nums1;
      quicksort(arr, 0, arr.length-1);
    }

    public static int[] quicksort(int[] arr, int low, int high){
        if (low<high){
            int pivotIndex = partition(arr,low,high);
            quicksort(arr, low, pivotIndex-1); //left side
            quicksort(arr, pivotIndex+1, high); //right side
        }
        return arr;
    }

    public static int partition(int[] arr, int low, int high){
        int pivot=arr[high]; 
        int i = low;

        for (int j=low; j<high; j++){
            if (arr[j]<=pivot){
            
                //swap arr[i] & [j]
                int temp=arr[j];
                arr[j]= arr[i];
                arr[i]=temp;
                i++;
            }
        }
        //swap pivot to correct position -put it to the high pos?
        int temp=arr[i];
        arr[i]=arr[high];
        arr[high]=temp;
       
        return i; //returns
    }

     public static String reverseWords(String s) {
        StringBuilder rev=new StringBuilder();
        String[] words=s.split(" ");
        for (int i = words.length-1; i > -1; i--) {
            if (!words[i].equals("")){
                rev.append(words[i]);          
                if (i!=0){
                    rev.append(" ");
                }
            }
        }
        return String.valueOf(rev).stripTrailing();
    }

     public static boolean isBracketValid(String s) {
        //i think all characters are a bracket [](){}
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static int evalRPN(String[] tokens) {
        String[] operations=new String[]{"+", "-","*","/"};
    
        return 0;
    }
}


