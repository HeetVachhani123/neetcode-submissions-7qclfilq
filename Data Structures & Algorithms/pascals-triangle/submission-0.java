class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // The first and last elements of each row are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Interior elements are the sum of the two elements directly above
                    List<Integer> prevRow = triangle.get(i - 1);
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}