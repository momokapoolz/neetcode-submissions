class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}

// tạo 1 hashset: là lưu các giá trị ko trùng
// duyệt từn item trong mảng, nếu nó có tồn tại trong hashset rồi => có lặp, còn ko có thì add mới vào hashset
// ví dụ: 1,2,3,1: check 1 lần đầu ko có thì add, 1 lần 2 có check thì thấy có trong hashset rồi => lặp