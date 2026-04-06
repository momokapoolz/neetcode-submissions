class Solution {
    public int climbStairs(int n) {
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;

        for (int i = 2; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }

        return steps[n];
    }
}

// đếm số bước có thể đi đến bậc n (mỗi lần đi có thể đi 1 hoắc 2 bước = tính là 1 lần)
// dùng đệ quy nhưng quy hoạch động
// để tính số bước đến i = (số bước i - 1) + (số bước i - 2): ví dụ số bước đến 3 = số bước đến 2 + số bước đến 1
// nếu n = 0 và 1 thì số bước luôn là 1
// thế thôi :)