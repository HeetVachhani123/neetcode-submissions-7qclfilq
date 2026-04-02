class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] arr= new int[n];

        for (int i=0;i<n;i++){
            int p=1;
            for (int j=0;j<n;j++){
                if (i==j) continue;
                else{
                    p=p*nums[j];
                }
            }
            arr[i]= p;
        }
        return (arr);
    }
}