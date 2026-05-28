
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // 1. Build the adjacency list graph
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Pair(v, prob));
            graph.get(v).add(new Pair(u, prob));
        }

        // 2. Array to store the maximum probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        // 3. Max-Heap based on probability
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Pair(start, 1.0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currNode = curr.node;
            double currProb = curr.prob;

            // If we reached the destination, this is the optimal path
            if (currNode == end) {
                return currProb;
            }

            // If we found a larger probability path to currNode already, skip this stale record
            if (currProb < maxProb[currNode]) {
                continue;
            }

            // 4. Explore neighbors
            for (Pair neighbor : graph.get(currNode)) {
                double newProb = currProb * neighbor.prob;

                // If the new path yields a higher probability, update and push to heap
                if (newProb > maxProb[neighbor.node]) {
                    maxProb[neighbor.node] = newProb;
                    pq.offer(new Pair(neighbor.node, newProb));
                }
            }
        }

        // If the end node is unreachable
        return 0.0;
    }

    // Helper class to store graph elements
    class Pair {
        int node;
        double prob;
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}