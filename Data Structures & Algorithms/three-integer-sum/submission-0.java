class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int a = nums[i];

            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            while (left < right) {
                int sum = nums[left] + nums[right] + a;

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(a, nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}


/*
3SUM - Two Pointer Pattern

Goal:
Tìm tất cả bộ ba (a, b, c) sao cho:
a + b + c = 0

--------------------------------
STEP 1: Sort mảng
--------------------------------
- Sort giúp:
  + Two pointer hoạt động (biết khi nào tăng / giảm tổng)
  + Các giá trị duplicate nằm cạnh nhau -> dễ skip

nums.sort()

--------------------------------
STEP 2: Fix phần tử đầu tiên (a)
--------------------------------
- Duyệt từng phần tử làm số đầu tiên của bộ ba
- Với mỗi nums[i], ta tìm 2 số còn lại sao cho:

nums[left] + nums[right] = -nums[i]

for i from 0 -> n-3

--------------------------------
STEP 3: Early stop optimization
--------------------------------
Nếu nums[i] > 0:
    break

Vì mảng đã sort nên:
nums[i] ≤ nums[left] ≤ nums[right]

=> tổng luôn > 0
=> không thể có bộ ba nào = 0

--------------------------------
STEP 4: Skip duplicate của a
--------------------------------
Nếu nums[i] == nums[i-1]:
    continue

Vì cùng giá trị a sẽ tạo ra cùng bộ kết quả.

--------------------------------
STEP 5: Two Pointer tìm 2 số còn lại
--------------------------------

left  = i + 1
right = n - 1

while left < right:

    sum = nums[i] + nums[left] + nums[right]

    if sum > 0:
        right--
        (giảm tổng)

    else if sum < 0:
        left++
        (tăng tổng)

    else:
        tìm được bộ ba hợp lệ
        add [nums[i], nums[left], nums[right]]

--------------------------------
STEP 6: Move pointer
--------------------------------
Sau khi tìm được result:

left++
right--

--------------------------------
STEP 7: Skip duplicate của left
--------------------------------

while left < right AND nums[left] == nums[left-1]:
    left++

Mục đích:
tránh tạo lại cùng bộ ba.

--------------------------------
STEP 8: Skip duplicate của right
--------------------------------

while left < right AND nums[right] == nums[right+1]:
    right--

--------------------------------
TIME COMPLEXITY
--------------------------------

Sort: O(n log n)

Outer loop: O(n)
Two pointer scan: O(n)

Total: O(n²)

--------------------------------
SPACE COMPLEXITY
--------------------------------

O(1) extra space (không tính result)
*/
