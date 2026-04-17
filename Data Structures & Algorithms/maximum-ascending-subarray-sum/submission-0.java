class Solution {
    public int maxAscendingSum(int[] arr) {
        int sum = 0;
        int fsum = 0;
        int max = 0;
        int i = 0;
        while(i<arr.length){
            if(arr[i] > max){
                max = arr[i];
                sum = sum + arr[i];              
            }else{
                fsum = Math.max(fsum,sum);
                sum= arr[i];
                max = arr[i];             
            }
            if(i == arr.length -1){
                fsum = Math.max(fsum,sum);
            }          
            i++;
        }
        return fsum;
    }    
}