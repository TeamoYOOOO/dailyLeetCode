import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
  public int numSubseq(int[] nums, int target) {
    Arrays.sort(nums);
    int res = 0, n = nums.length, l = 0, r = n - 1, mod = (int) (Math.pow(10, 9) + 7);//这个比写(int)1e9+7快
    int[] pows = new int[n];
    pows[0] = 1;
    for (int i = 1 ; i < n ; ++i)
      pows[i] = pows[i - 1] * 2 % mod;
    while (l <= r) {
      if (nums[l] + nums[r] > target) {
        r--;
      } else {
        res = (res + pows[r - l++]) % mod;
      }
    }
    return res;
  }
}
