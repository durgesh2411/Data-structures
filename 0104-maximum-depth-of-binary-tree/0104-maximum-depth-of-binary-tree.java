/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxHtRec(TreeNode root){
        if(root == null) return 0;
            int htLeftSub = maxHtRec(root.left);
            int htRightSub = maxHtRec(root.right);
        return 1 + Math.max(htLeftSub, htRightSub);
        
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int maxHeight = maxHtRec(root);
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);
        // int maxHt = 0;
        // while(!q.isEmpty()){
        //     int size = q.size();
        //     while(size > 0){
        //         TreeNode cNode = q.poll();
        //         if(cNode.left != null) q.add(cNode.left);
        //         if(cNode.right != null) q.add(cNode.right);
        //         size--;
        //     }
        //     maxHt++;
        // }
        // return maxHt;
        return maxHeight;
    }
}