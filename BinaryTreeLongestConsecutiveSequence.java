public class BinaryTreeLongestConsecutiveSequence {
  public int longestConsecutive(TreeNode root) {
    int[] max = new int[1];
    helper(root, null, 0, max);
    return max[0];
  }

  private void helper(TreeNode root, Integer prev, int len, int[] max){
    if(root == null) return;
    if(prev == null || root.val == prev+1){
      len++;
      max[0] = Math.max(max[0], len);
      helper(root.left, root.val, len, max);
      helper(root.right, root.val, len, max);
    }else{
      helper(root.left, root.val, 1, max);
      helper(root.right, root.val, 1, max);
    }
  }

  //--------Recursion w/o max variable----------
//     public int longestConsecutive(TreeNode root) {
//         return dfs(root, null, 0);
//     }

//     private int dfs(TreeNode root, Integer prev, int count){
//         if(root == null) return count;
//         count = (prev != null && root.val == prev+1)? count+1: 1;
//         int left = dfs(root.left, root.val, count);
//         int right = dfs(root.right, root.val, count);
//         return Math.max(count,Math.max(left, right));
//     }

  //------------recursion w/ max variable------------快
//     public int longestConsecutive(TreeNode root) {
//         return dfs(root, null, 0, 0);
//     }

//     private int dfs(TreeNode root, Integer prev, int count, int max){
//         if(root == null) return max;
//         count = (prev != null && root.val == prev+1)? count+1: 1;
//         max = Math.max(max, count);
//         int left = dfs(root.left, root.val, count, max);
//         int right = dfs(root.right, root.val, count, max);
//         return Math.max(left, right);
//     }
}
