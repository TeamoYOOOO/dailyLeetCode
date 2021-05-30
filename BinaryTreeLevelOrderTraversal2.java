public class BinaryTreeLevelOrderTraversal2 {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    if(root == null) return res;
    q.add(root);
    while(!q.isEmpty()){
      int size = q.size();
      List<Integer> l = new ArrayList<>();
      for(int x = 0; x < size; x++){
        TreeNode curr = q.poll();
        l.add(curr.val);
        if(curr.left != null){q.add(curr.left);}
        if(curr.right != null){q.add(curr.right);}
      }
      res.add(0, l);
    }
    return res;
  }
}
