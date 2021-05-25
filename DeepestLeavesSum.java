public class DeepestLeavesSum {
  public int deepestLeavesSum(TreeNode root) {
    int[] max = new int[1];
    int[] res = new int[1];
    helper(root, 1, max, res);
    return res[0];
  }

  private void helper(TreeNode root, int level, int[] max, int[] res){
    if(root == null) return;
    if(level > max[0]){
      max[0] = level;
      res[0] = 0;
    }
    if(level == max[0]) res[0] += root.val;
    helper(root.left, level+1, max, res);
    helper(root.right, level+1, max, res);
  }

//     int res = 0;
//     public int deepestLeavesSum(TreeNode root) {
//         Queue<TreeNode> q = new LinkedList<>();
//         if(root == null) return res;
//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             res = 0;
//             for(int x = 0; x < size; x++){
//                 TreeNode curr = q.poll();
//                 if(curr.left == null && curr.right == null){
//                     res += curr.val;
//                 }
//                 if(curr.left != null) q.add(curr.left);
//                 if(curr.right != null) q.add(curr.right);
//             }
//         }
//         return res;

//     }



  // int maxLevel = 0;
  // int total = 0;
  // public int deepestLeavesSum(TreeNode root) {
  //     helper(root, 0);
  //     return total;
  // }
  // private void helper(TreeNode root, int level){
  //     if(root == null) return;
  //     if(level > maxLevel){
  //         maxLevel = level;
  //         total = 0;
  //     }
  //     if(root.left == null && root.right == null && level == maxLevel)
  //         total += root.val;
  //     helper(root.left, level+1);
  //     helper(root.right, level+1);
  //     // if(root.left == null && root.right == null && level == maxLevel)
  //     //     total += root.val;
  // }


  //-----------------Queue-------------------
  // public int deepestLeavesSum(TreeNode root) {
  //     if(root == null) return 0;
  //     Queue<TreeNode> q = new LinkedList<>();
  //     int total = 0;
  //     q.add(root);
  //     while(!q.isEmpty()){
  //         int size = q.size();
  //         total = 0;
  //         for(int x = 0; x < size; x++){
  //             TreeNode curr = q.poll();
  //             total += curr.val;
  //             if(curr.left != null) q.add(curr.left);
  //             if(curr.right != null) q.add(curr.right);
  //         }
  //     }
  //     return total;
  // }
}
