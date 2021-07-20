public class ValidTriangleNumber {
  public int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int count = 0, n = nums.length;
    for (int i=n-1;i>=2;i--) {
      int l = 0, r = i-1;
      while (l < r) {
        if (nums[l] + nums[r] > nums[i]) {
          count += r-l;//r-l的意思是l到r-1的所有数和r还有i都可以组成三角形
          r--;
        }
        else l++;
      }
    }
    return count;
  }



  //还是TLE 因为worse case还是O(N^3) 没有重复数字的时候
  // public int triangleNumber(int[] nums) {
  //     int count = 0;
  //     HashMap<Integer, Integer> hm = new HashMap<>();
  //     for(int x = 0; x < nums.length; x++){
  //         hm.put(nums[x],hm.getOrDefault(nums[x], 0)+1);
  //     }
  //     hm.remove(0);
  //     for(int x : hm.keySet()){
  //         if(hm.get(x) > 2){
  //             for(int i = 0; i < hm.get(x)-1; i++){
  //                 count += factorial(i);
  //             }
  //         }
  //         for(int y : hm.keySet()){
  //             if(x < y && (hm.get(x)>1 || hm.get(y)>1)){//!!!!保证是从小到大就不会有重复计算
  //                 if(x+x > y){//只要检查等腰那边满足大于第三边就好
  //                     count += factorial(hm.get(x)-1)*hm.get(y);
  //                 }
  //                 if(y+y > x){
  //                     count += factorial(hm.get(y)-1)*hm.get(x);
  //                 }
  //             }
  //             for(int z : hm.keySet()){
  //                 if(x < y && y < z){//!!!!
  //                     if(x+y > z && x+z > y && y+z > x){
  //                         count += hm.get(x)*hm.get(y)*hm.get(z);
  //                     }
  //                 }
  //             }
  //         }
  //     }
  //     return count;
  // }
  // private int factorial(int num){
  //     int sum = 0;
  //     for(int x = 1; x <= num; x++){//不能是0到num-1 必须是1到num
  //         sum+=x;
  //     }
  //     return sum;
  // }
  


  //---------------TLE-----------------
  // public int triangleNumber(int[] nums) {
  //     int count = 0;
  //     for(int x = 0; x < nums.length; x++){
  //         for(int y = x+1; y < nums.length; y++){
  //             for(int z = y+1; z < nums.length; z++){
  //                 if(validateTriangle(nums[x], nums[y], nums[z])) count++;
  //             }
  //         }
  //     }
  //     return count;
  // }
  // private boolean validateTriangle(int x, int y, int z){
  //     if(x+y > z && x+z > y && y+z > x)
  //         return true;
  //     return false;
  // }
}
