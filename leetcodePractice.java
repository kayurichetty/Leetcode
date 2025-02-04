public class leetcodePractice {
    public static void main(String[] args) {
        int[] nums = { 3, 6, 10, 1, 8, 9, 9, 8, 9 };
        System.out.println(maxAscendingSum(nums));
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
}
