

class Solution {
    public int[] frequencySort(int[] nums) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        
        // count frequency
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // convert to Integer[] for sorting
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        
        // custom sort
        Arrays.sort(arr, (a, b) -> {
            if (freq.get(a) != freq.get(b)) {
                return freq.get(a) - freq.get(b); // increasing freq
            } else {
                return b - a; // decreasing value
            }
        });
        
        // convert back to int[]
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
        
        return nums;
    }
}