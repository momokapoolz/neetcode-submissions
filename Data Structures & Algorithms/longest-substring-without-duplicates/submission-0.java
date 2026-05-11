class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();

        HashSet<Character> set = new HashSet<>();

        int max = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            while (set.contains(arr[right])) {
                set.remove(arr[left]);
                left++;
            }

            set.add(arr[right]);

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}

// set dùng để lưu các ký tự KHÔNG bị trùng trong window hiện tại

// right chính là i trong vòng for
// window hiện tại sẽ là từ left -> right

// nếu gặp ký tự bị lặp:
//  - dịch left sang phải
//  - remove các ký tự cũ khỏi set
//  - làm đến khi ký tự hiện tại không còn bị trùng nữa
// => bỏ ký tự cũ để giữ window luôn hợp lệ

// sau khi window hợp lệ:
// add ký tự hiện tại vào set

// độ dài window hiện tại:
// right - left + 1

// right luôn tăng dần
// left chỉ tăng khi có duplicate
// => window sẽ tự co giãn để luôn giữ substring không trùng ký tự