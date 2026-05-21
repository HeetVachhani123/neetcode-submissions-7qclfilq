

// Definition for a binary tree node.
/*
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
*/

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString();
    }
    
    // Helper method for serialization
    private void serializeDFS(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N").append(",");
            return;
        }
        
        // Pre-order: Root -> Left -> Right
        sb.append(node.val).append(",");
        serializeDFS(node.left, sb);
        serializeDFS(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Split the string and add all elements to a queue
        String[] vals = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(vals));
        
        return deserializeDFS(queue);
    }
    
    // Helper method for deserialization
    private TreeNode deserializeDFS(Queue<String> queue) {
        String val = queue.poll();
        
        // Base case: if we hit our null marker, return null
        if (val.equals("N")) {
            return null;
        }
        
        // Create the node and recursively build its subtrees
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeDFS(queue);
        node.right = deserializeDFS(queue);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));