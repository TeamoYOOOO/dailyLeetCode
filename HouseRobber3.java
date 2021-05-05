import javax.swing.tree.TreeNode;

public class HouseRobber3 {
//     HashMap<TreeNode, Integer> robResult = new HashMap<>();
//     HashMap<TreeNode, Integer> notRobResult = new HashMap<>();

//     public int helper(TreeNode node, boolean parentRobbed) {
//         if (node == null) {
//             return 0;
//         }
//         if (parentRobbed) {
//             if (robResult.containsKey(node)) {
//                 return robResult.get(node);
//             }
//             int result = helper(node.left, false) + helper(node.right, false);
//             robResult.put(node, result);
//             return result;
//         } else {
//             if (notRobResult.containsKey(node)) {
//                 return notRobResult.get(node);
//             }
//             int rob = node.val + helper(node.left, true) + helper(node.right, true);
//             int notRob = helper(node.left, false) + helper(node.right, false);
//             int result = Math.max(rob, notRob);
//             notRobResult.put(node, result);
//             return result;
//         }
//     }

//     public int rob(TreeNode root) {
//         return helper(root, false);
//     }



  public int rob(TreeNode root) {
    if (root == null) return 0;
    return Math.max(robInclude(root), robExclude(root));
  }

  public int robInclude(TreeNode node) {
    if(node == null) return 0;
    return robExclude(node.left) + robExclude(node.right) + node.val;
  }

  public int robExclude(TreeNode node) {
    if(node == null) return 0;
    return rob(node.left) + rob(node.right);//注意是rob 不一定要include
  }
}
