class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[' ) {
                stack.push(s.charAt(i));
            } 
            
            else {
                if ( stack.empty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if (top  == '{' && s.charAt(i) == '}') {
                        stack.pop();
                    }
                    else if (top  == '(' && s.charAt(i) == ')') {
                        stack.pop();
                    }
                    else if (top  == '[' && s.charAt(i) == ']') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}

// ý tưởng: duyệt qua tùng kí tự i của chuỗi s, nếu i là ngoặc mở thì thêm vào stack rỗng
/* nếu i là ngoặc đóng, thì so sánh với top của stack, nếu cùng 1 cặp thì xóa cái top đấy đi (pop) -> phát hiện đc ngoặc nào chưa đóng
vì nếu đóng thì trong stack ko còn nó nx
*/
// nếu tất cả ngoặc đều đóng thì stack rỗng, vì cứ đóng đúng là bỏ ra khỏi stack, nếu stack ko rỗng => là có ngoặc chưa đóng
