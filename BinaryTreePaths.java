public class BinaryTreePaths {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    helper(root, res, new ArrayList<>());
    return res;
  }
  private void helper(TreeNode root, List<String> res, List<Integer> path){
    if(root == null) return;
    path.add(root.val);
    if(root.left == null && root.right == null){
      StringBuilder sb = new StringBuilder();
      for(int x = 0; x < path.size(); x++){
        if(x != path.size()-1){
          sb.append(path.get(x) + "->" );
        }else{
          sb.append(path.get(x));
        }
      }
      res.add(sb.toString());
      path.remove(path.size()-1);
      return;
    }
    helper(root.left, res, path);
    helper(root.right, res, path);
    path.remove(path.size()-1);
  }


//     public List<String> binaryTreePaths(TreeNode root) {
//         List<String> res = new ArrayList<>();
//         dfs(root, res, new ArrayList<TreeNode>());
//         return res;
//     }

//     private void dfs(TreeNode root, List<String> res, List<TreeNode> l){
//         if(root == null) return;
//         l.add(root);
//         if(root.left == null && root.right == null){
//             res.add(listToString(l));
//             l.remove(l.size()-1);//如果这里return记得更新size()-1因为不会走到下面
//             return; //可以在这return 不过dfs到base也可以 就是多花一点时间
//         }
//         dfs(root.left, res, l);
//         dfs(root.right, res, l);
//         l.remove(l.size()-1);
//     }

//     private String listToString(List<TreeNode> l){
//         StringBuilder sb = new StringBuilder();
//         for(int x = 0; x < l.size(); x++){
//             sb.append(l.get(x).val);
//             if(x != l.size()-1){
//                 sb.append("->");
//             }
//         }
//         return sb.toString();
//     }



  //----------------Backtracking-----------------
//     public List<String> binaryTreePaths(TreeNode root) {
//         List<String> res = new ArrayList<>();
//         dfs(root, res, new StringBuilder());
//         return res;
//     }
//     private void dfs(TreeNode root, List<String> res, StringBuilder sb){
//         if(root == null) return;
//         if(sb.length() == 0){
//             sb.append(root.val);
//         }
//         else{
//             sb.append("->" + root.val);
//         }
//         if(root.left == null && root.right == null){
//             res.add(sb.toString());
//         }
//         dfs(root.left, res, sb);
//         dfs(root.right, res, sb);
//         sb.setLength(Math.max(sb.length()-countLen(root.val)-2,0));//慢
//     }
//     private int countLen(int i){
//         int count = 0;
//         if(i < 0){
//             count++; i *= -1;
//         }
//         while(i > 0){
//             i /= 10;
//             count++;
//         }
//         return count;
//     }
}
