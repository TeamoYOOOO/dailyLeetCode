public class PathSum3 {
  public int pathSum(TreeNode root, int sum) {
    int[] res = new int[1];
    HashMap<Integer, Integer> hm = new HashMap<>();
    hm.put(0,1);
    helper(root, sum, res, hm, 0);
    return res[0];
  }

  private void helper(TreeNode root, int sum, int[] res,  HashMap<Integer, Integer> hm, int total){
    if(root == null) return;
    total += root.val; 
    res[0] += hm.getOrDefault(total - sum, 0);
    hm.put(total, hm.getOrDefault(total, 0)+1);
    helper(root.left, sum, res, hm, total);
    helper(root.right, sum, res, hm, total);
    hm.put(total, hm.get(total)-1);

  }
//     int res = 0;
//     public int pathSum(TreeNode root, int sum) {
//         Map<Integer, Integer> hm = new HashMap<>();
//         hm.put(0, 1);
//         helper(root, sum, 0, hm);
//         return res;
//     }

//     private void helper(TreeNode root, int sum, int currSum, Map<Integer, Integer> hm){
//         if(root == null) return;
//         currSum += root.val;
//         if(hm.containsKey(currSum - sum)) res += hm.get(currSum - sum);
//         hm.put(currSum, hm.getOrDefault(currSum, 0) + 1);
//         helper(root.left, sum, currSum, hm);
//         helper(root.right, sum, currSum, hm);
//         hm.put(currSum, hm.get(currSum) - 1);
//     }
}
