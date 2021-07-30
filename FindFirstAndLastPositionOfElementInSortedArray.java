public class FindFirstAndLastPositionOfElementInSortedArray {
  //找左侧：
  //		1. r用nums.length-1 正常写
  //		2. r用nums.length 需要单独检查`if (left == nums.length) return -1;` case([1,2,2,2,3] 4) - 找的值大于所有数
  //找右侧
  //		1. r必须用nums.length不能用-1
  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    res[0] = findFirst(nums, target);
    res[1] = findLast(nums, target);
    return res;
  }

  private int findFirst(int[] nums, int target){
    if(nums.length == 0) return -1;
    int l = 0, r = nums.length-1;
    while(l < r){
      int mid = l + (r-l)/2;
      if(nums[mid] >= target){
        r = mid;
      }else{
        l = mid+1;
      }
    }
    return nums[l] == target? l:-1;
  }

  private int findLast(int[] nums, int target){
    if(nums.length == 0) return -1;
    // if(nums.length == 1) return nums[0] == target? 0: -1;
    int l = 0, r = nums.length;//如果这里写nums.length-1的话 len为1 2 的corner case都很特殊 如果是nums.length的话 上面可以comment out所有case都能过 难顶
    while(l < r){
      int mid = l + (r-l)/2;
      if(nums[mid] > target){
        r = mid;
      }else{
        l = mid+1;
      }
    }
    return (l == 0 || nums[l-1] != target)? -1:l-1;
  }

//     public int[] searchRange(int[] nums, int target) {
//         int[] res = new int[2];
//         res[0] = findFirst(nums, target);
//         res[1] = findLast(nums, target);
//         return res;
//     }

//     private int findFirst(int[] nums, int target){
//         if (nums.length == 0) return -1;
//         int left = 0, right = nums.length;
//         while(left < right){
//             int mid = left + (right - left)/2;
//             if(nums[mid] < target){
//                 left = mid + 1;
//             }else{
//                 right = mid;
//             }
//         }
//         return (left == nums.length || nums[left] != target)? -1:left;
//     }

//     private int findLast(int[] nums, int target){
//         if (nums.length == 0) return -1;
//         int left = 0, right = nums.length;
//         while(left < right){
//             int mid = left + (right - left)/2;
//             if(nums[mid] <= target){
//                 left = mid + 1;
//             }else{
//                 right = mid;
//             }
//         }
//         return (left == 0 || nums[right-1] != target)? -1 : right-1;
//     }
}
