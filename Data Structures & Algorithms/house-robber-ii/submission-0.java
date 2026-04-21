class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int case1 = normalRob(1, n-1, nums);
        int case2 = normalRob(0, n-2, nums);

        return Math.max(case1, case2);
    }

    public int normalRob(int start, int end, int[] nums) {
        int length = end - start + 1;

        if (length == 1) {
            return nums[start];
        }

        int[] dp = new int[length];
        
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);


        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i-2] + nums[start + i]);
        }

        return dp[length - 1];
    }
}
