public class MaximumAscendingSubarraySum {
  public int maxAscendingSum(int[] nums) {
    int largest = -1;
    int sum = 0;
    int res = 0;
    for(int x = 0; x < nums.length; x++){
      if(nums[x] > largest){
        sum += nums[x];
        largest = nums[x];
      }else{
        res = Math.max(res, sum);
        sum = nums[x];
        largest = nums[x];
      }
    }
    res = Math.max(res, sum);
    return res;
  }
}
