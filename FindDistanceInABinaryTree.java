public class FindDistanceInABinaryTree {
  public int findDistance(TreeNode root, int p, int q) {
    if(p == q) return 0;
    boolean[] meet = new boolean[1];
    return helper(root, p, q, meet);
  }
  private int helper(TreeNode root, int p, int q, boolean[] meet){
    if(root == null) return -1;
    int left = helper(root.left, p, q, meet);
    int right = helper(root.right, p, q, meet);
    if(root.val == p || root.val == q){
      if(left == -1 && right == -1){
        return 1;
      }else{
        meet[0] = true;
        return left == -1 ? right: left;
      }
    }
    else{
      if(left == -1 && right == -1){
        return -1;
      }else if(left == -1 || right == -1){
        if(meet[0]) return left == -1 ? right: left;
        else return left == -1 ?right + 1: left + 1;
      }else{
        meet[0] = true;
        return left + right;
      }
    }
  }
}
