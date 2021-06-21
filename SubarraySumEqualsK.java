public class SubarraySumEqualsK {
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> hm = new HashMap<>();
    int sum = 0, count = 0; hm.put(0, 1);
    for(int x = 0; x < nums.length; x++){
      sum += nums[x];
      count += hm.getOrDefault(sum - k, 0);
      hm.put(sum, hm.getOrDefault(sum, 0)+1);
    }
    return count;
  }
}
