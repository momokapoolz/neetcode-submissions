class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }
}

// Bài này giống Climbing Stairs nhưng thay vì đếm số cách, ta cần tìm chi phí nhỏ nhất để lên tới đỉnh.

// dp[i] = chi phí nhỏ nhất để đứng ở bậc i

// Để tới bậc i, có 2 cách:
// - đi từ i-1 (nhảy 1 bước)

// => chọn đường có tổng cost nhỏ hơn:
// dp[i] = cost[i] + min(dp[i-1], dp[i-2])

// Kết quả cuối:
// không phải dp[n-1], mà là min(dp[n-1], dp[n-2])
// vì từ 2 bậc này đều có thể nhảy lên top
