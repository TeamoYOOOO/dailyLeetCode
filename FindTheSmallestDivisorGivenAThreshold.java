public class FindTheSmallestDivisorGivenAThreshold {
  public int smallestDivisor(int[] nums, int threshold) {
    int l = 1, r = 1000000;
    while(l < r){
      int mid = l + (r-l)/2;
      int count = 0;
      for(int x = 0; x < nums.length; x++){
        count += (nums[x] + mid -1)/mid;
      }
      if(count <= threshold){
        r = mid;
      }else{
        l = mid + 1;
      }
    }
    return l;
  }
}
