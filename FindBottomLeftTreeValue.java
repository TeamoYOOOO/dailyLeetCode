public class FindBottomLeftTreeValue {
  public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int res = -1;
    while(!q.isEmpty()){
      int size = q.size();
      for(int x = 0; x < size; x++){
        TreeNode curr = q.poll();
        if(x == 0) res = curr.val;
        if(curr.left != null) q.add(curr.left);
        if(curr.right != null) q.add(curr.right);
      }
    }
    return res;
  }
}
