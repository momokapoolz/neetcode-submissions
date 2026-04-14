class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String[]> tempList = new ArrayList<>();

        // B1: convert + sort từng string
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            tempList.add(new String[]{sorted, strs[i]});
        }

        // B2: sort toàn bộ theo sorted key
        tempList.sort((a, b) -> a[0].compareTo(b[0]));

        // B3: group các phần tử liền kề giống nhau
        List<String> currentGroup = new ArrayList<>();
        currentGroup.add(tempList.get(0)[1]);

        for (int i = 1; i < tempList.size(); i++) {
            if (tempList.get(i)[0].equals(tempList.get(i - 1)[0])) {
                currentGroup.add(tempList.get(i)[1]);
            } else {
                result.add(currentGroup);
                currentGroup = new ArrayList<>();
                currentGroup.add(tempList.get(i)[1]);
            }
        }

        // thêm group cuối
        result.add(currentGroup);

        return result;
    }
}
