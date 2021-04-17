public class MaximumSubarray {
  public int maxSubArray(int[] nums) {
    int currMax = nums[0], max = nums[0];
    for(int x = 1; x < nums.length; x++){
      currMax = Math.max(currMax + nums[x], nums[x]);
      max = Math.max(max, currMax);
    }
    return max;
  }
}
