class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        // row 0
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        result.add(ans);

        // agar rowIndex = 0
        if (rowIndex == 0) return ans;

        for (int i = 1; i <= rowIndex; i++) {   // 🔧 < → <=
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = result.get(i - 1);

            row.add(1);
            for (int j = 0; j < i - 1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            row.add(1);

            result.add(row);
        }
        return result.get(rowIndex);   // 🔧 rowIndex-1 → rowIndex
    }
}
