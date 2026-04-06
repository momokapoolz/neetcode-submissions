class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!seen.contains(nums[i])) {
                seen.add(nums[i]);
            } else {
                seen.remove(nums[i]);
            }
        }

        int result = seen.stream().findFirst().get();
        return result;
    }
}

// tạo 1 hashset, hashset chứa phàn tử ko lặp
// duyệt mảng và add vào hashset, nếu phần tử chưa tồn tại trong hashset thì thêm vào hashset, còn tồn tại thì xóa phần tử này trong hashset
// hashset sẽ chứa 1 phần tử ko bị xóa (single number)
// dùng .stream().findFirst().get() để lấy phần tử đầu tiên(có mỗi 1 cái ní) tong hashset