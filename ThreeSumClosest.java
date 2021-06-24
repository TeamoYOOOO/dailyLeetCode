public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    Integer res = null;//用null合理 不能用MAX e.g. [-3,-2,-5,3,-4] -1
    for(int x = 0; x < nums.length; x++){
      int l = x+1, r = nums.length-1;
      if(x != 0 && nums[x] == nums[x-1]) continue;
      while(l < r){
        int sum = nums[r] + nums[l] + nums[x];
        if(sum == target){
          return target;
        }else if(sum > target){
          r--;
        }else{
          l++;
        }
        res = res == null || Math.abs(sum - target) < Math.abs(res - target)? sum : res;
      }
    }
    return res;
  }
}
