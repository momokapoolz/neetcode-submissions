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
