public class PathSum {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    return helper(root, 0, targetSum);
  }

  private boolean helper(TreeNode root, int prev, int target){
    if(root == null) return false;
    if(root.left == null && root.right == null && prev+root.val == target){
      return true;
    }
    return helper(root.left, prev+root.val, target) || helper(root.right, prev+root.val, target);
  }

//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         if(root == null) return false;
//         return helper(root, targetSum);
//     }

//     public boolean helper(TreeNode root, int targetSum){
//         if(root == null) return false;
//         if(root.left == null && root.right == null) return targetSum-root.val == 0;
//         return helper(root.left, targetSum-root.val) || helper(root.right, targetSum-root.val);
//     }
}
