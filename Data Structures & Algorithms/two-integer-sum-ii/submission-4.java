class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int[] ans = new int[2];
        boolean flag = false;
        for(int i = 0; i<n; i++){
            for(int j =i+1; j<n; j++){
                if(arr[i]+arr[j] == target){
                    ans[0]=i+1;
                    ans[1]=j+1;
                    flag = true;
                }
            }if(flag == true){
                break;
            }
        }return ans;
    }    
}
