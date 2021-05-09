public class JumpGame6 {
  // DP + Monotonic Queue
  public int maxResult(int[] nums, int k) {
    int len = nums.length;
    int[] dp = new int[len];   // dp[i] : max sum from 0-th index to i-th index, following the given conditions
    Deque<Integer> deque = new ArrayDeque<Integer>();    // for each index i, front of the deque will be storing max{dp[i-k], dp[i-k-1], dp[i-k-2], .... , dp[i-2], dp[i-1]}
    for(int i = 0; i < len; i++) {
      int prev_max = deque.isEmpty() ? 0 : dp[deque.peekFirst()];//找当前deque的first 也就是前k个box里的最大值
      dp[i] = nums[i] + prev_max;//最大值+当前值就是dp[i]的值
      while(!deque.isEmpty() && dp[deque.peekLast()] < dp[i])
        deque.pollLast();//检查对比当前的box的值 保证queue是递减的
      deque.add(i);//加入当前box的值
      while(!deque.isEmpty() && i - deque.peekFirst() >= k)
        deque.pollFirst();//确保queue里头只有前面k的的范围值
    }
    return dp[len-1];
  }


  //--------------dp---TLE---------
  // public int maxResult(int[] nums, int k) {
  //     int n = nums.length;
  //     int[] dp = new int[n];
  //     Arrays.fill(dp, Integer.MIN_VALUE);
  //     dp[0] = nums[0];
  //     for(int x = 0; x < n; x++){
  //         if(x == 0){
  //             dp[0] = nums[0];
  //         }
  //         else{
  //             for(int y = 1; y <= k; y++){
  //                 if(x-y >= 0) dp[x] = Math.max(nums[x] + dp[x-y], dp[x]);
  //             }
  //         }
  //     }
  //     return dp[n-1];
  // }
}
