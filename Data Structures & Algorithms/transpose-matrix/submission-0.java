class Solution {
    public int[][] transpose(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] res = new int[n][m];

        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
                res[j][i] = arr[i][j];
            }
        }
        return res;
    }
}