/*class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}*/


class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Map to store the mapping from original nodes to their clones.
        // This also acts as a visited set.
        HashMap<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        // Start with the initial node.
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node originalNode = queue.poll();
            Node clonedNode = visited.get(originalNode);

            // Iterate through the neighbors of the original node.
            for (Node neighbor : originalNode.neighbors) {
                // If a neighbor hasn't been cloned yet:
                if (!visited.containsKey(neighbor)) {
                    // Create its clone.
                    Node newNeighborClone = new Node(neighbor.val, new ArrayList<>());
                    // Add it to the map and the queue to process its neighbors later.
                    visited.put(neighbor, newNeighborClone);
                    queue.add(neighbor);
                }
                // Add the clone of the neighbor to the neighbor list of the current cloned node.
                clonedNode.neighbors.add(visited.get(neighbor));
            }
        }

        // Return the clone of the starting node.
        return visited.get(node);
    }
}