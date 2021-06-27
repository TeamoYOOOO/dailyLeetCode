public class FindTheDuplicateNumber {
  public int findDuplicate(int[] nums) {
    //bit manipulation不行 因为repeat不代表出现2次
    // int num = 0;
    // for(int x = 1; x < nums.length; x++){
    //     num ^= x;
    // }
    // for(int x = 0; x < nums.length; x++){
    //     num ^= nums[x];
    //     // num ^= (x+1);
    // }
    // return num;

    Arrays.sort(nums);
    int left = 0, right = nums.length-1;
    while(left < right){
      int mid = left + (right - left)/2;
      int count = 0;
      for(int i : nums){
        if(i <= mid) count++;
      }
      if(count<= mid){
        left = mid + 1;
      }
      else{
        right = mid;
      }
    }
    return left;
  }

//     public int findDuplicate(int[] nums) {
//         int slow = nums[0];
// 		int fast = nums[nums[0]];
// 		while (slow != fast){
// 			slow = nums[slow];
// 			fast = nums[nums[fast]];
// 		}
// 		fast = 0;
// 		while (fast != slow){
// 			fast = nums[fast];
// 			slow = nums[slow];
// 		}
// 		return slow;
//     }

  // public int findDuplicate(int[] nums) {
  //     boolean[] arr = new boolean[60000];
  //     for(int x = 0; x < nums.length; x++){
  //         int i = 30000 + nums[x];
  //         if(arr[i]) return nums[x];
  //         arr[i] = true;
  //     }
  //     return -1;
  // }
}
