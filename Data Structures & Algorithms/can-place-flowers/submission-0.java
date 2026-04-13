class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        for (int i = 0; i < flowerbed.length; i++) {
            
            // check if current is empty
            if (flowerbed[i] == 0) {
                
                // check left
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                
                // check right
                boolean rightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                
                // if both sides are empty → plant flower
                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;
                    n--;
                    
                    if (n == 0) {
                        return true;
                    }
                }
            }
        }
        
        return n <= 0;
    }
}