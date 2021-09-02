public class ContiguousArray {
  public int findMaxLength(int[] nums) {
    //用一个count记录 0的话+1 1的话-1 记录每次count对应的index(如果hm有就不加 直接更新对比max 没有的话 把对应的count放进去) 只需要找到跟当前count一样的最前面的index 这就是01数量相同的范围
    HashMap<Integer, Integer> hm = new HashMap<>();
    int count = 0;//increment if 0, decrement if 1
    int max = 0;
    hm.put(0, -1);
    for(int x = 0; x < nums.length; x++){
      if(nums[x] == 0) count++;
      if(nums[x] == 1) count--;
      // max = Math.max(max, x - hm.getOrDefault(count, x));
      // hm.put(count, hm.getOrDefault(count, x));
      if(hm.containsKey(count)){
        max = Math.max(max, x - hm.get(count));//有这个key就不更新 因为要留最远的index
      }else{
        hm.put(count, x);
      }
    }
    return max;
  }
}
