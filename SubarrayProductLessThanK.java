public class SubarrayProductLessThanK {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int l = 0, r = 0, prod = 1, res = 0;
    while(r < nums.length){
      prod *= nums[r];
      while(l <= r && prod >= k){//注意要保证l<=r
        prod /= nums[l];
        l++;
      }
      res += r-l+1;
      r++;
    }
    return res;
  }
}
