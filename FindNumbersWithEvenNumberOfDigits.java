public class FindNumbersWithEvenNumberOfDigits {
  public int findNumbers(int[] nums) {
    int odd = 0;//count of odd number of digits
    for(int x = 0; x < nums.length; x++){
      int curr = nums[x];
      while(curr > 0){
        curr = curr/10;
        if(curr == 0){
          odd++;
          break;
        }
        curr = curr/10;
      }
    }
    return nums.length-odd;
  }
}
