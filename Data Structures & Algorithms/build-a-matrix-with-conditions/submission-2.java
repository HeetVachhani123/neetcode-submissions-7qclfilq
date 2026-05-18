class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // 1. Get the topological sort order for rows and columns
        int[] rowOrder = topoSort(k, rowConditions);
        int[] colOrder = topoSort(k, colConditions);
        
        // 2. If a cycle is detected in either, return an empty matrix
        if (rowOrder.length == 0 || colOrder.length == 0) {
            return new int[0][0];
        }
        
        // 3. Map each number (1 to k) to its assigned row and column index
        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];
        for (int i = 0; i < k; i++) {
            rowPos[rowOrder[i]] = i;
            colPos[colOrder[i]] = i;
        }
        
        // 4. Build the final matrix
        int[][] matrix = new int[k][k];
        for (int i = 1; i <= k; i++) {
            matrix[rowPos[i]][colPos[i]] = i;
        }        
        return matrix;
    }  
    // Helper method to perform Topological Sort using Kahn's Algorithm
    private int[] topoSort(int k, int[][] conditions) {
        List<Integer>[] graph = new ArrayList[k + 1];
        int[] inDegree = new int[k + 1];
        
        for (int i = 0; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }      
        // Build the graph and calculate in-degrees
        for (int[] edge : conditions) {
            graph[edge[0]].add(edge[1]);
            inDegree[edge[1]]++;
        }       
        // Push all nodes with 0 in-degree into the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }      
        int[] order = new int[k];
        int index = 0;
        
        // Process the queue
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;
            
            for (int neighbor : graph[curr]) {
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }       
        // If index == k, we successfully sorted all elements. Otherwise, there's a cycle.
        return index == k ? order : new int[0];
    }
}