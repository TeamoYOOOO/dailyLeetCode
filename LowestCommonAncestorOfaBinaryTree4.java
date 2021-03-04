public class LowestCommonAncestorOfaBinaryTree4 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
    TreeNode[] res = new TreeNode[1];
    HashSet<TreeNode> hs = new HashSet<>();
    for(TreeNode t: nodes){
      hs.add(t);
    }
    helper(root, hs, res);
    return res[0];
  }
  private int helper(TreeNode root, HashSet<TreeNode> hs, TreeNode[] res){
    if(root == null) return 0;
    int left = helper(root.left, hs, res);
    int right = helper(root.right, hs, res);
    int count = right + left;
    if(hs.contains(root)) count++;
    if(hs.size() == count && res[0] == null){
      res[0] = root;
    }
    return count;
  }

}
