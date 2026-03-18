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
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dia(root);
        return dia;
    }
    private int dia(TreeNode root){
        if(root == null) return 0;
        int lh = dia(root.left);
        int rh = dia(root.right);

        dia = Math.max(lh+rh,dia);
        return Math.max(lh,rh)+1;
    }
}