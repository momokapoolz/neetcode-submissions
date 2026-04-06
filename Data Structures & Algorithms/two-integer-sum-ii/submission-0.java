class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if ( numbers[left] + numbers[right] < target ) {
                left++;
            }
            else if ( numbers[left] + numbers[right] > target) {
                right--;
            } else {
                return new int[]{left+1, right+1};
            }
        }
        return new int[]{0, 0};
    }
}

// 1 mảng chi tăng dần nên ko cần hashmap để tìm đối
// 2 con trỏ ở 2 đầu cuối, cộng 2 phần tử đầu cuối và so sánh với target, nếu < target thì tăng left lên để cộng tiếp và ngược lại