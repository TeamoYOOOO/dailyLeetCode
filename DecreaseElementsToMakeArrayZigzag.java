public class DecreaseElementsToMakeArrayZigzag {
  public int movesToMakeZigzag(int[] nums) {
    if(nums.length == 1) return 0;//edge case!!!!
    int odd = 0, even = 0;//降even/odd
    for(int x = 0; x < nums.length; x++){
      if(x%2 == 0){//降even 也就是让odd成为比临边大的
        if(x == 0){
          even += Math.max(nums[x]-nums[x+1]+1,0);
        }else if(x == nums.length-1){
          even += Math.max(nums[x]-nums[x-1]+1,0);
        }else{
          even += Math.max(Math.max(nums[x]-nums[x-1]+1, nums[x]-nums[x+1]+1),0);
        }
      }else{
        if(x == nums.length-1){
          odd += Math.max(nums[x]-nums[x-1]+1,0);
        }else{
          odd += Math.max(Math.max(nums[x]-nums[x-1]+1, nums[x]-nums[x+1]+1),0);
        }
      }
    }
    return Math.min(odd, even);
  }
}
