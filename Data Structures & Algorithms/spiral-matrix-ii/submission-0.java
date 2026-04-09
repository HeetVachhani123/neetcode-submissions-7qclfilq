class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int minc = 0 , maxc = n-1;
        int minr = 0, maxr = n-1;

        int k = 1;
        while(minc <= maxc && minr <= maxr){   
            for(int i=minc; i<=maxc; i++){
                arr[minr][i] = k;
                k++;
            }minr++;
            if(minr > maxr || minc > maxc){break;}
            for(int i=minr; i<=maxr; i++){
                arr[i][maxc] = k;               
                k++;
            }maxc--;
            if(minr > maxr || minc > maxc){break;}
            for(int i=maxc; i>=minc; i--){
                arr[maxr][i] = k;             
                k++;
            }maxr--;
            if(minr > maxr || minc > maxc){break;}
            for(int i=maxr; i>=minr; i--){
                arr[i][minc] = k;
                k++;
            }minc++;
        }return arr;
    }
}