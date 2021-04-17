public class HouseRobber {
  public int rob(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    for(int x = 0; x < dp.length; x++){
      if(x == 0)
        dp[x] = nums[x];
      else if(x == 1)
        dp[x] = Math.max(nums[x], nums[x-1]);
      else
        dp[x] = Math.max(dp[x-1], dp[x-2]+nums[x]);
    }
    return dp[n-1];
  }
}
