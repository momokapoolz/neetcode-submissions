class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diff = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            diff.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int different = target - nums[i];
            if (diff.containsKey(different) && diff.get(different) != i) {
                return new int[] {i, diff.get(different)};
            }
        }
        return new int[0];
    }
}

// Tạo 1 map lưu giá trị và index của mảng
// tạo 1 diff = target - nums[i]
// check xem trong map diff ko
// nếu có thì là trả về index của diff và i là đc
// bởi vì nếu diff có trong map nghĩa là nums tại i và trong map đó có += target, thì trả về i và i của cái diff trong map
