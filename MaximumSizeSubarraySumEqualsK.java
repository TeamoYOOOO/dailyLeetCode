public class MaximumSizeSubarraySumEqualsK {
  public int maxSubArrayLen(int[] nums, int k) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    hm.put(0, -1);
    int sum = 0, max = 0;
    for(int x = 0; x < nums.length; x++){
      sum += nums[x];
      if(hm.containsKey(sum - k))
        max = Math.max(max, x - hm.get(sum-k));
      hm.put(sum, hm.getOrDefault(sum, x));//getOrDefualt后面写的是default也就是新的x值
    }
    return max;
  }



  // public int maxSubArrayLen(int[] nums, int k) {
  //     Map<Integer, Integer> hm = new HashMap<>();
  //     int sum = 0; hm.put(0, -1); int max = 0;
  //     for(int x = 0; x < nums.length; x++){
  //         sum += nums[x];
  //         if(hm.containsKey(sum-k))
  //             max = Math.max(max,x-hm.get(sum-k));
  //         if(!hm.containsKey(sum))
  //             hm.put(sum, x);
  //     }
  //     return max;
  // }
}
