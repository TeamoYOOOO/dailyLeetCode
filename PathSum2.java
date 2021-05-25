public class PathSum2 {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> res = new ArrayList<>();
    helper(root, targetSum, res, new ArrayList<>());
    return res;
  }
  private void helper(TreeNode root, int rest, List<List<Integer>> res, List<Integer> curr){
    if(root == null) return;
    curr.add(root.val);
    if(root.left == null && root.right == null && rest == root.val){
      res.add(new ArrayList<>(curr));//!!!!new
    }
    helper(root.left, rest-root.val, res, curr);
    helper(root.right, rest-root.val, res, curr);
    curr.remove(curr.size()-1);
  }



//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         List<List<Integer>> res = new ArrayList<>();
//         dfs(root, targetSum, new ArrayList<>() ,res);
//         return res;
//     }

//     private void dfs(TreeNode root, int sum, List<Integer> l, List<List<Integer>> res){
//         if(root == null) return;
//         l.add(root.val);
//         if(root.left == null && root.right == null){
//             if(sum == root.val){
//                 res.add(new ArrayList<>(l));//deep copy!!
//             }
//             l.remove(l.size()-1);//outside the if!!
//             return;
//         }
//         dfs(root.left, sum-root.val, l, res);
//         dfs(root.right, sum-root.val, l, res);
//         l.remove(l.size()-1);
//     }
}
