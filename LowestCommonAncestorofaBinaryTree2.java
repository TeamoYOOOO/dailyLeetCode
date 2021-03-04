public class LowestCommonAncestorofaBinaryTree2 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int[] count = new int[1];
    TreeNode res = helper(root, p, q, count);
    return count[0] == 2 ? res : null;
  }

  private TreeNode helper(TreeNode root, TreeNode p, TreeNode q, int[] count){
    if(root == null) return null;
    TreeNode left = helper(root.left, p, q, count);
    TreeNode right = helper(root.right, p, q, count);
    if(root == p || root == q){
      count[0]++;
      return root;
    }
    if(left != null && right != null) return root;
    return left == null? right :left;
  }
}
