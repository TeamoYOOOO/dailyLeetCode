public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
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
      res.add(l);
    }
    return res;
  }
}
