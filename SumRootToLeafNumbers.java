public class SumRootToLeafNumbers {
  public int sumNumbers(TreeNode root) {
    int res = new int[1];
    helper(root, 0, res);
    return res;
  }

  private void helper(TreeNode root, int prev, int res){
    if(root == null) return;
    int curr = prev*10 + root.val;
    if(root.left == null && root.right == null){
      res += curr;
    }
    helper(root.left, curr, res);
    helper(root.right, curr, res);

  }

//     public int sumNumbers(TreeNode root) {
//         // Integer total = 0;
//         int[] total = new int[1];
//         dfs(root, 0, total);
//         return total[0];
//     }

//     private void dfs(TreeNode root, int pathSum, int[] total){
//         if(root == null) return;
//         pathSum = pathSum*10 + root.val;
//         if(root.left == null && root.right == null){
//             total[0] += pathSum;
//             return;
//         }
//         dfs(root.left, pathSum, total);
//         dfs(root.right, pathSum, total);
//     }
}
