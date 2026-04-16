class Solution {
    public int[] replaceElements(int[] arr) {
        for(int i=0; i<arr.length; i++){
            int max = Integer.MIN_VALUE;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] > max){
                max = arr[j];
                }
            }
            if(i == arr.length -1){
                max= -1;
            }
            int temp = arr[i];
            arr[i] = max; 
            max = temp;
            
        }return arr;
    }
}