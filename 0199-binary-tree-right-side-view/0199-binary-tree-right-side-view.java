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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> track = new LinkedList<>();
        track.offer(root);

        while(!track.isEmpty()){
            int size = track.size();
            for(int i=0;i<size;i++){
                TreeNode node = track.poll();
                if(i==size - 1){
                    result.add(node.val);
                }
                if(node.left!=null) track.offer(node.left);
                if(node.right!=null) track.offer(node.right);
            }
        }
        return result;
    }
}