public class HouseRobber2 {
  public int rob(int[] nums) {
    if(nums.length == 1) return nums[0];
    int n = nums.length;
    int[] dp = new int[n];
    for(int x = 0; x < n-1; x++){
      if(x == 0){
        dp[x] = nums[x];
      }else if(x == 1){
        dp[x] = Math.max(nums[x], dp[x-1]);
      }else{
        dp[x] = Math.max(dp[x-2] + nums[x], dp[x-1]);
      }
    }

    int[] dp2 = new int[n];
    for(int x = 1; x < n; x++){
      if(x == 1){
        dp2[x] = nums[x];
      }else if(x == 2){
        dp2[x] = Math.max(nums[x], dp2[x-1]);
      }else{
        dp2[x] = Math.max(dp2[x-2] + nums[x], dp2[x-1]);
      }
    }

    return Math.max(dp[dp.length-2],dp2[dp2.length-1]);
  }
}
