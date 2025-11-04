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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int r = solve(root);
        return ans;
    }

    public int solve(TreeNode root){
        if(root==null) return 0;
        int leftSum = Math.max(0,solve(root.left));
        int rightSum = Math.max(0,solve(root.right));

        // now chech that path sum is max or not
        ans = Math.max(ans,(leftSum + rightSum + root.val));
        return Math.max(leftSum, rightSum) + root.val;
    }
}