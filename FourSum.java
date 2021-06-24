public class FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for(int x = 0; x < nums.length; x++){
      if(x != 0 && nums[x] == nums[x-1]) continue;
      for(int y = x+1; y < nums.length; y++){
        if(y != x+1 && nums[y] == nums[y-1]) continue;//因为数值可以相同 但是答案要unique 所以只有xy相邻的时候 值一样才行 别的时候 都说明y前面的重复值已经被take过了 (所以就是跟x的loop一样 只是排除y是这个loop循环第一个数的情况 也就是xy相邻的时候)
        int l = y+1, r = nums.length-1;
        while(l < r){
          int sum = nums[r] + nums[l] + nums[x] + nums[y];
          // if(nums[r] != nums[l] && sum == target){ 注意是index不同 不是value
          if(sum == target){
            res.add(Arrays.asList(nums[l], nums[r], nums[x], nums[y]));
            l++; r--;
            while(l < nums.length && nums[l] == nums[l-1]) l++;
            while(r >= 0 && nums[r] == nums[r+1]) r--;
          }else if(sum > target){
            r--;
          }else{
            l++;
          }
        }
      }
    }
    return res;
  }
}
