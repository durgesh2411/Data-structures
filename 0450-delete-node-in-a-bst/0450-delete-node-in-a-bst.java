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

    public TreeNode connect(TreeNode node) {
        if(node.left == null) return node.right;
        if(node.right == null) return node.left;
        TreeNode leftChildNode = node.left;
        TreeNode leftMostChildNodeRightSubtree = node.right;
        while(leftMostChildNodeRightSubtree.left != null){
            leftMostChildNodeRightSubtree = leftMostChildNodeRightSubtree.left;
        }
        leftMostChildNodeRightSubtree.left = leftChildNode;
        return node.right;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            return connect(root);
        }

        TreeNode node = root;
        while(node != null) {
            if(key < node.val ){
                if(node.left != null && key == node.left.val){
                node.left = connect(node.left);
                }
                else node = node.left;
            }
            else if( key > node.val) {
                if(node.right != null && key == node.right.val){
                    node.right = connect(node.right);
                }
                else node = node.right;
            }
        }
        return root;
    }
}