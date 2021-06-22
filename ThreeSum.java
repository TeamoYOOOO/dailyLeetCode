public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for(int x = 0; x < nums.length; x++){
      int l = x+1, r = nums.length-1;
      if(x != 0 && nums[x] == nums[x-1]) continue;
      while(l < r){
        int sum = nums[r] + nums[l] + nums[x];
        // if(nums[r] != nums[l] && sum == 0){ 注意是index不同 不是value
        if(sum == 0){
          res.add(Arrays.asList(nums[l], nums[r], nums[x]));
          l++; r--;
          while(l < nums.length && nums[l] == nums[l-1]) l++;//但是答案要unique所以跳过重复的数值
          while(r >= 0 && nums[r] == nums[r+1]) r--;
        }else if(sum > 0){
          r--;
        }else{
          l++;
        }
      }
    }
    return res;
  }
}
