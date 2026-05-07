class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
                    
        list.sort((a, b) -> b.getValue() - a.getValue());

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }
}

// tạo 1 hashmap tương ứng và lưu các giá trị trong nums và số lần lặp của nó
// biến thành list để sort
// sort từ cao đến thấp
// lấy k phần tử đầu tiên trong list (sorted desc btw)
