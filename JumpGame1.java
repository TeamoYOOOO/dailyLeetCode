public class JumpGame1 {
  //greedy
  public boolean canJump(int[] nums) {
    int max = 0;
    for(int i = 0;i< nums.length;i++){
      if(i > max) {return false;}
      max = Math.max(nums[i]+i,max);
    }
    return true;
  }

  //dp
//  public boolean canJump(int[] nums) {
//     boolean[] dp = new boolean[nums.length];
//     dp[dp.length-1] = true;
//     for(int x = nums.length-2; x >= 0; x--){
//         for(int y = nums[x]; y > 0; y--){
//             if(x+y < nums.length && dp[x+y]){
//                 dp[x] = true;
//                 break;
//             }
//         }
//     }
//     return dp[0];
//  }
}
