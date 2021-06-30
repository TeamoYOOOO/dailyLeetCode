public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int target, int[] nums) {
    int min = Integer.MAX_VALUE;
    int l = 0, r = 0, sum = 0;
    while(r < nums.length){
      sum += nums[r++];
      while(sum >= target){//似乎不需要l < nums.length 因为满足sum>=target的话l不能超出去
        min = Math.min(min, r-l);//如果前面更新r就是r-l 后面更新就是r-l+1
        sum -= nums[l];
        l++;
      }
      // r++;
    }
    return min == Integer.MAX_VALUE? 0 :min;//如果min还是最大值即遍历完没满足的 return 0

    // int min = Integer.MAX_VALUE;
    // int l = 0, r = 0, sum = 0;
    // while(r < nums.length){
    //     sum += nums[r];
    //     while(l < nums.length && sum >= target){
    //         min = Math.min(min, r-l+1);
    //         sum -= nums[l];
    //         l++;
    //     }
    //     r++;
    // }
    // return min == Integer.MAX_VALUE? 0 : min;
  }
}
