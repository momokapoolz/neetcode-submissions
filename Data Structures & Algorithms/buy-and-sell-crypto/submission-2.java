class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            int currentProfit = prices[i] - min;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
        
        return maxProfit;
    }
}

// Duyệt mảng đúng 1 lần
// minPrice: giá thấp nhất đã gặp từ đầu đến ngày hiện tại (giả sử mua ở ngày này)
// Tại mỗi ngày i, giả sử ta bán ở giá prices[i]
// → lợi nhuận lúc này = prices[i] - minPrice
// So sánh lợi nhuận đó với maxProfit hiện tại và cập nhật nếu lớn hơn
// vừa cập nhật minPrice, vừa cập nhật maxProfit


