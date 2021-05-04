public class JumpGame2 {
  public int jump(int[] nums) {
    int[] dp = new int[nums.length];
    dp[dp.length-1] = 1;
    for(int x = nums.length-2; x >= 0; x--){
      for(int y = nums[x]; y > 0; y--){
        if(x+y < nums.length && dp[x+y] > 0){
          dp[x] = dp[x] == 0? dp[x+y]+1 : Math.min(dp[x],dp[x+y]+1);
        }
      }
    }
    return dp[0]-1;
  }
}
