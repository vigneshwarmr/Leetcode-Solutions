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
    Map<TreeNode,Integer> dp = new HashMap<>();
    public int rob(TreeNode root) {
        
        if(root==null)return 0;

        int pick = root.val;

        if(dp.containsKey(root)){
            return dp.get(root);
        }

        if(root.left!=null){
            pick+= rob(root.left.left);
            pick+= rob(root.left.right);
        }

        if(root.right!=null){
            pick+= rob(root.right.left);
            pick+= rob(root.right.right);
        }

        int notpick = rob(root.left)+rob(root.right);
        int ans = Math.max(pick,notpick);
        dp.put(root,ans);

        return ans;
    }
}