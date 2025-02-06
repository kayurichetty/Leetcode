public class leetcodePractice {
    public static void main(String[] args) {
        // int[] nums = { 3, 6, 10, 1, 8, 9, 9, 8, 9 };
        // System.out.println(maxAscendingSum(nums));
       // System.out.println(areAlmostEqual("bank", "kanb"));
       int[]  nums = {2,3,4,6};
       System.out.println(tupleSameProduct(nums));

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
        String newS1="";
        
        if (s1.equals(s2)){
            return true;
        }else if (s1.length() != s2.length()){
            return false;
        } 

        for (int i = 0; i < s1.length()-1; i++) {
            for (int index = i+1; index < s1.length(); index++) {
                System.out.println("Swapping: "+ s1.charAt(i) + " with " + s1.charAt(index));
                if (i==0){
                     newS1= s1.charAt(index) + s1.substring(i+1, index)+ s1.substring(i,i+1)+ s1.substring(index+1);
                }else{
                     newS1= s1.substring(0, i)+ s1.charAt(index) + s1.substring(i+1, index)+ s1.substring(i,i+1)+ s1.substring(index+1);
                }
               
                //System.out.println(newS1);
                if (newS1.equals(s2)){
                    return true;
                }
            }
        }
        return false;
    }

    public static int tupleSameProduct(int[] nums) {

        return 0;
        
    }
}
    
}
