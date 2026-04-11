class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
                
        int total = 0;
        int n = costs.length;
        
        for (int i = 0; i < n/2; i++) {
            total = total + costs[i][0];
        }
        for (int i = n/2; i < n; i++) {
            total = total + costs[i][1];
        }
        return total;
    }
}