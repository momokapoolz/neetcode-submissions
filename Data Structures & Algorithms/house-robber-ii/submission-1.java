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

/*
Vì nhà đầu (0) và nhà cuối (n-1) kề nhau nên KHÔNG thể cướp cả hai.
Do đó, chia thành 2 trường hợp độc lập:
Cướp trong đoạn [1 → n-1] (bỏ nhà 0)
Cướp trong đoạn [0 → n-2] (bỏ nhà n-1)
Kết quả = max của 2 trường hợp trên.

HÀM normalRob(start, end):

Xử lý bài toán House Robber I trên đoạn con [start → end]
Ta coi đoạn này như một mảng mới bắt đầu từ index 0

Định nghĩa:

dp[i] = số tiền tối đa có thể cướp từ "đầu đoạn" đến vị trí i

Mapping:

dp[0] = nums[start]
dp[1] = nums[start + 1]

Khởi tạo:

dp[0] = nums[start]
dp[1] = max(nums[start], nums[start+1])
(vì không thể cướp 2 nhà liền kề)

Công thức DP:

Với mỗi i ≥ 2:
dp[i] = max(
dp[i-1], // không cướp nhà hiện tại
dp[i-2] + nums[start+i] // cướp nhà hiện tại
)

Giải thích:

Nếu không cướp nhà i → giữ kết quả tốt nhất trước đó (dp[i-1])
Nếu cướp nhà i → phải bỏ nhà i-1 → cộng với dp[i-2]
*/
