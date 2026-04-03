class Solution {
    public int maxArea(int[] arr) {
        int n= arr.length;
        int i=0;
        int j=n-1;
        int nmax=0;
        while(i!=j){
            int max = (j-i)*Math.min(arr[i],arr[j]);
            if (max>nmax){
                nmax=max;
            }
            if (arr[i]<arr[j]){
                i++;
            }else{
                j--;
            }
        }
        return nmax;
    }
}