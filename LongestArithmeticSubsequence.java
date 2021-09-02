public class LongestArithmeticSubsequence {
  public int longestArithSeqLength(int[] nums) {
    // int n = nums.length, res = 2;
    // HashMap<Integer, Integer>[] dp = new HashMap[n];
    // for(int x = 0; x < nums.length; x++){
    //     dp[x] = new HashMap<>();
    //     for(int y = 0; y < x; y++){
    //         int diff = nums[x] - nums[y];
    //         dp[x].put(diff, dp[y].getOrDefault(diff, 0)+1);
    //         res = Math.max(res, dp[x].get(diff)+1);
    //     }
    // }
    // return res;


    int res = 2, n = nums.length;
    HashMap<Integer, Integer>[] dp = new HashMap[n];
    for (int j = 0; j < nums.length; j++) {
      dp[j] = new HashMap<>();
      for (int i = 0; i < j; i++) {
        int d = nums[j] - nums[i];
        dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
        res = Math.max(res, dp[j].get(d));
      }
    }
    return res;
  }
}
