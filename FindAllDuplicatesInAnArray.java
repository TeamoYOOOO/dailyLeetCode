public class FindAllDuplicatesInAnArray {
  public List<Integer> findDuplicates(int[] nums) {
    //巧用index 和 正负来看是否重复 因为范围是1-n 且不出现的不需要考虑
    List<Integer> res = new ArrayList<>();
    for(int x = 0; x < nums.length; x++){
      int index = Math.abs(nums[x])-1;
      if(nums[index] < 0){
        res.add(Math.abs(nums[x]));
      }
      nums[index] *= -1;
    }
    return res;
  }
}
