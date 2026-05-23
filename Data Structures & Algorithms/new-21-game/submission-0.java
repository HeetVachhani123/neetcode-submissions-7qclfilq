class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // Edge case 1: If k is 0, Alice stops immediately with 0 points.
        // Edge case 2: The maximum points Alice can possibly get is k - 1 + maxPts.
        // If n is greater than or equal to this theoretical maximum, she is guaranteed to win.
        if (k == 0 || n >= k - 1 + maxPts) {
            return 1.0;
        }

        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        
        double Wsum = 1.0; // The sliding window sum of probabilities
        double res = 0.0;  // The accumulated probability of ending with <= n points

        for (int i = 1; i <= n; i++) {
            // The probability of getting exactly 'i' points
            dp[i] = Wsum / maxPts;

            // If we are below the stopping threshold, we can continue drawing
            if (i < k) {
                Wsum += dp[i];
            } else {
                // If we reached or exceeded k, we stop drawing. 
                // Add this probability to our final success result.
                res += dp[i];
            }

            // Remove the probability that is no longer reachable in a single draw (falls out of window)
            if (i - maxPts >= 0) {
                // We only subtract it if it was originally added to Wsum 
                // (it was only added if the index was < k)
                if (i - maxPts < k) {
                    Wsum -= dp[i - maxPts];
                }
            }
        }

        return res;
    }
}