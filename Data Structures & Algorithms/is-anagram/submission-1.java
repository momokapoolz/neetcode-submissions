class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}

// sắp xếp lại tất cả char trong 2 chuỗi theo thứ tự (ASCII chắc thế), thành 2 mảng char
// xong chỉ cần so sánh xem 2 mảng char giống nhau hay ko là đc
// vì nếu là anagram thì số kí tự xuất hiện giống/= nhau, chỉ khác thứ tự thôi nên sort rồi so sánh là ra