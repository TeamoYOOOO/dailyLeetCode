public class CountNumberOfNiceSubarrays {
  public int numberOfSubarrays(int[] nums, int k) {
    return atMost(nums, k) - atMost(nums, k - 1);
  }
  public int atMost(int[] A, int k) {
    int res = 0, l = 0, n = A.length;
    for (int r = 0; r < n; r++) {
      k -= A[r] % 2;
      while (k < 0)
        k += A[l++] % 2;
      res += r - l + 1;//r-l+1就是当前l开始count有多少个以r结束的subarray 一次挪动一个l有多少个subarray
    }
    return res;
  }




  //--------------array当hm--------------
  // int[] hm = new int[nums.length+1];
  // hm[0] = 1; int res = 0, count = 0;
  // for(int x = 0; x < nums.length; x++){
  //     if(nums[x] % 2 == 1) count++;
  //     if(count >= k) res += hm[count-k];//count可能小于k 需要检查condition
  //     hm[count]++;
  // }
  // return res;

  //------------------HashMap-----------------
  // Map<Integer, Integer> hm = new HashMap<>();
  // int count = 0, res = 0; hm.put(0, 1);
  // for(int x = 0; x < nums.length; x++){
  //     if(nums[x] % 2 == 1) count++;
  //     res += hm.getOrDefault(count-k, 0);
  //     hm.put(count, hm.getOrDefault(count, 0)+1);
  // }
  // return res;
  // }
}
