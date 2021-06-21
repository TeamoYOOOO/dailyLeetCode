public class ProductOfArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int[] left = new int[nums.length]; left[0] = 1;
    int[] right = new int[nums.length]; right[right.length-1] = 1;
    int[] res = new int[nums.length];
    for(int x = 1; x < nums.length; x++){
      left[x] = left[x-1] * nums[x-1];
    }
    for(int x = nums.length-2; x >= 0; x--){
      right[x] = right[x+1] * nums[x+1];
    }
    for(int x = 0; x < res.length; x++){
      res[x] = left[x] * right[x];
    }
    return res;
  }
}
