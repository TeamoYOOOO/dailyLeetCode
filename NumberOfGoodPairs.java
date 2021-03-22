public class NumberOfGoodPairs {
  public int numIdenticalPairs(int[] nums) {
    int[] hm = new int[101];
    int count = 0;
    for(int x = 0; x < nums.length; x++){
      count += hm[nums[x]];
      hm[nums[x]]++;
    }
    return count;
  }
}
