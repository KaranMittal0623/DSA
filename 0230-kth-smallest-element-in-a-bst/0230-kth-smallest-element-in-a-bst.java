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
    int count = 1;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        // Left side last me jao or check kro
        int a = kthSmallest(root.left,k);
        // Agr 1st hi nikalna toh return krdo nhi toh count ko increment krte rho
        if(count == k) ans = root.val;
        count++;
        // Right side dekho
        int b = kthSmallest(root.right,k);
        // ab dono side traverse krne ke baad ans me kuj toh store hoga hi vahi return krdo 
        return ans;

    }
}