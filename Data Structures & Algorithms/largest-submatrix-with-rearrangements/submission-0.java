
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;
        
        // Step 1: Precompute consecutive 1s for each column vertically
        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 1) {
                    matrix[r][c] += matrix[r - 1][c];
                }
            }
        }
        
        // Step 2 & 3: For each row, sort heights and find the max rectangle
        for (int r = 0; r < rows; r++) {
            // Clone or use a copy if you don't want to break the vertical heights for rows below,
            // but since we process top-to-bottom, we can safely sort the current row directly.
            Arrays.sort(matrix[r]);
            
            // Since Arrays.sort() sorts in ascending order, the largest elements are at the end.
            // We iterate backwards: index 'cols - 1' is the largest, 'cols - 2' is 2nd largest, etc.
            for (int i = cols - 1; i >= 0; i--) {
                if (matrix[r][i] == 0) {
                    break; // No more 1s available in this row
                }
                
                // Width is the number of columns with height >= matrix[r][i]
                int width = cols - i; 
                int currentArea = matrix[r][i] * width;
                
                maxArea = Math.max(maxArea, currentArea);
            }
        }
        
        return maxArea;
    }
}