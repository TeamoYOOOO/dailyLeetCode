public class KthSmallestElementinaBST {
  public int kthSmallest(TreeNode root, int k) {
    int[] curr = new int[1];
    return helper(root, curr, k);
  }

  private int helper(TreeNode root, int[] num, int k){
    if(root == null) return -1;
    int left = helper(root.left, num, k);
    num[0]++;
    if(num[0] == k) return root.val;
    int right = helper(root.right, num, k);
    return left == -1 ? right: left;
  }



  //-----Iteration using Stack with 1 while loop------
  // public int kthSmallest(TreeNode root, int k) {
  //     TreeNode p = root;
  //     Deque<TreeNode> stack = new ArrayDeque<>();
  //     while(!stack.isEmpty() || p != null){
  //         if(p != null){
  //             stack.push(p);
  //             p = p.left;
  //         }else{
  //             p = stack.poll();
  //             k--;
  //             if(k == 0) return p.val;
  //             p = p.right;
  //         }
  //     }
  //     return -1;//no kth
  // }


  //----------Iteration using Stack------------
  // public int kthSmallest(TreeNode root, int k) {
  //     Deque<TreeNode> stack = new ArrayDeque<>();
  //     while(root != null){
  //         stack.push(root);
  //         root = root.left;
  //     }
  //     while(!stack.isEmpty()){
  //         TreeNode curr = stack.poll();
  //         k--;
  //         if(k == 0) return curr.val;
  //         curr = curr.right;
  //         while(curr != null){
  //             stack.push(curr);
  //             curr = curr.left;
  //         }
  //     }
  //     return -1;//no kth
  // }



  //------------------Recursion------------------
//     public int kthSmallest(TreeNode root, int k) {
//         int[] res = new int[1];
//         helper(root, k, 1, res);
//         return res[0];
//     }
//     private int helper(TreeNode root, int k, int num, int[] res){
//         if(root == null) return num;
//         num = helper(root.left, k, num, res);
//         //从1开始算 所以每次return的其实是下一个node的第几位 所以先检查再更新
//         if(num == k) res[0] = root.val;
//         num += 1;
//         num = helper(root.right, k, num, res);
//         return num;
//     }
}
