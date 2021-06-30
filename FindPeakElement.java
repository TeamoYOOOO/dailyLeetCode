public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    int l = 0, r = nums.length-1;
    while(l < r){
      int mid = l + (r-l)/2;
      if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])){
        return mid;
      }else if(mid == 0 || nums[mid] > nums[mid-1]){//要check index. case: [1,2]
        l = mid+1;
      }else{
        r = mid;
      }
    }
    return l;


    // public int findPeakElement(int[] nums) {
    //     int left = 0, right = nums.length-1;
    //     while(left <= right){
    //         int mid = left + (right - left)/2;
    //         if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])){
    //             return mid;
    //         }else if(mid == nums.length-1 || nums[mid] > nums[mid+1]){
    //             right = mid - 1;
    //         }else{
    //             //else if(nums[mid] > nums[mid-1]) 这么写再[3,1,2]会TLE 遇到谷就TLE
    //             left = mid + 1;
    //         }
    //     }
    //     return left;
    // }
  }
}
