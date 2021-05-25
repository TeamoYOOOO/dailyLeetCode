public class TrimaBinarySearchTree {
  public TreeNode trimBST(TreeNode root, int low, int high) {
    if(root == null) return root;
    if(root.val < low) return trimBST(root.right, low, high);
    if(root.val > high) return trimBST(root.left, low, high);
    root.left = trimBST(root.left, low, high);
    root.right = trimBST(root.right, low, high);
    // if(root.val < low) return trimBST(root.right, low, high);
    // if(root.val > high) return trimBST(root.left, low, high);上面下面都可以
    return root;
  }

  // public TreeNode trimBST(TreeNode root, int low, int high) {
  //     if(root == null) return null;
  //     // if(root.val<low || root.val > high) return (root.left == null)? root.right: root.left; 不可以写这
  //     root.left = trimBST(root.left, low, high);
  //     root.right = trimBST(root.right, low, high);
  //     if(root.val<low || root.val > high) return (root.left == null)? root.right: root.left;
  //     return root;
  // }
}
