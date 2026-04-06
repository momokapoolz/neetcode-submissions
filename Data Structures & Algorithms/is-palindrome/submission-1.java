class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }
        
        return true;
    }
}

// cơ bản là đảo ngược lại chuỗi r so sánh
// nên cho nhanh thì 1 vòng while và 2 biến left right ở đầu và cuối, trước đó đổi chuỗi thành mảng kí tự
// left tăng right giảm, so sánh phần tử ở vị trí left và right
// nếu khác nhau thì false, kí tự đặc biệt thì continue
