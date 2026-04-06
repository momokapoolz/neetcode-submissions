class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> differentMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            differentMap.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];

            if (differentMap.containsKey(difference) && differentMap.get(difference) != i) {
                return new int[] { i, differentMap.get(difference) };
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
