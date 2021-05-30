public class InvertBinaryTree {
  //top down或者bottom up都行 只要每一排的左右都对调了就好
  //--------------Recursion--------------
  public TreeNode invertTree(TreeNode root) {
    if(root == null) return root;
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }
  //-------------Iteraation with Queue-------------
  // public TreeNode invertTree(TreeNode root) {
  //     if (root == null) return null;
  //     Queue<TreeNode> queue = new LinkedList<TreeNode>();
  //     queue.add(root);
  //     while (!queue.isEmpty()) {
  //         TreeNode current = queue.poll();
  //         TreeNode temp = current.left;
  //         current.left = current.right;
  //         current.right = temp;
  //         if (current.left != null) queue.add(current.left);
  //         if (current.right != null) queue.add(current.right);
  //     }
  //     return root;
  // }
}
