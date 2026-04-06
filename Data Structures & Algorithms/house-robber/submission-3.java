class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i-2] + nums[i]);
        }

        return dp[n - 1];
    }
}

/* dp[i] là max tiền từ nhà 0 → i, có thể cướp hoặc không cướp nhà i, 
nếu cướp i thì lấy (i-2) + i vì i-1 là nhà liền kề, còn nếu ko cướp i thì cướp i-1 */

// 2 nhà đầu là gốc dp, lấy max

// nếu n = 1 (chỉ có 1 nhà) thì cướp luôn chứ sao nx

