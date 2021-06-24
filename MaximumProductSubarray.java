public class MaximumProductSubarray {
  public int maxProduct(int[] nums) {
    int[] max = new int[nums.length];
    int[] min = new int[nums.length];
    int res = nums[0];
    //如果单独在外面assign min max 0 的值 res也得设置为nums[0] 确保只有一个数的case也对 / 要么就是在for里面写 res就是开始设置为最小值
    min[0] = nums[0]; max[0] = nums[0];
    for(int x = 1; x < nums.length; x++){
      if(nums[x] < 0){
        max[x] = Math.min(1, min[x-1])*nums[x];
        min[x] = Math.max(1, max[x-1])*nums[x];
      }else{
        max[x] = Math.max(1, max[x-1])*nums[x];
        min[x] = Math.min(1, min[x-1])*nums[x];
      }
      res = Math.max(res, Math.max(max[x], min[x]));
    }
    return res;
  }

  //在for里面分index0的case res就是开始设置为最小值
//  public int maxProduct(int[] nums) {
//    int[] max = new int[nums.length];
//    int[] min = new int[nums.length];
//    int res = Integer.MIN_VALUE;
//    for(int x = 0; x < nums.length; x++){
//      if(x == 0){
//        max[x] = nums[x];
//        min[x] = nums[x];
//      }else{
//        if(nums[x] > 0){
//          max[x] = Math.max(max[x-1], 1)*nums[x];
//          min[x] = Math.min(min[x-1], 1)*nums[x];
//        }else{
//          max[x] = Math.min(min[x-1], 1)*nums[x];
//          min[x] = Math.max(max[x-1], 1)*nums[x];
//        }
//      }
//      res = Math.max(Math.max(min[x], max[x]), res);
//    }
//    return res;
//  }
}
