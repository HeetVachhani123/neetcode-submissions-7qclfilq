class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int [] nums3 = new int[m+n];

        for(int i = 0; i < m; i++){
            nums3[i] = nums1[i];
        }
        for(int j = 0; j < n; j++){
            nums3[m+j] = nums2[j];
        }
        Arrays.sort(nums3);

        int k = nums3.length;
        double ans;

        if(k % 2 == 0){
            ans = (nums3[k/2] + nums3[k/2 - 1])/2.0;
        }else{
            ans = nums3[k/2];
        }
        return ans;
    }
}