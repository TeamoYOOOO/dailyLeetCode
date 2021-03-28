import java.util.HashMap;
import java.util.Map;

public class NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers {
  // 1 <= nums1[i], nums2[i] <= 10^5 需要用Long

  // public int numTriplets(int[] nums1, int[] nums2) {
  //     int count = 0;
  //     for(int x = 0; x < nums1.length; x++){
  //         Map<Long, Long> hm = new HashMap<>();
  //         long sqr = (long)nums1[x]*(long)nums1[x];//long!
  //         for(long i: nums2){//可以long不可以Long
  //             if(sqr % i == 0){
  //                 count += hm.getOrDefault(sqr/i, 0l);//0l - long
  //             }
  //             hm.put(i,hm.getOrDefault(i, 0l)+1);//i!
  //         }
  //     }
  //     for(int x = 0; x < nums2.length; x++){
  //         Map<Long, Long> hm = new HashMap<>();
  //         long sqr = (long)nums2[x]*(long)nums2[x];
  //         for(long i: nums1){
  //             if(sqr % i == 0){
  //                 count += hm.getOrDefault(sqr/i, 0l);
  //             }
  //             hm.put(i,hm.getOrDefault(i, 0l)+1);
  //         }
  //     }
  //     return count;
  // }


  // 用for each loop代替for loop
  public int numTriplets(int[] nums1, int[] nums2) {
    int count = 0;
    for(long l : nums1){
      Map<Long, Long> hm = new HashMap<>();
      long sqr = l*l;//直接乘
      for(long i: nums2){//可以long不可以Long
        if(sqr % i == 0){
          count += hm.getOrDefault(sqr/i, 0l);//0l - long
        }
        hm.put(i,hm.getOrDefault(i, 0l)+1);//i!
      }
    }
    for(long l : nums2){
      Map<Long, Long> hm = new HashMap<>();
      long sqr = l*l;
      for(long i: nums1){
        if(sqr % i == 0){
          count += hm.getOrDefault(sqr/i, 0l);
        }
        hm.put(i,hm.getOrDefault(i, 0l)+1);
      }
    }
    return count;
  }


  //---------Discussion 区用helper method-----------
  // public int numTriplets(int[] nums1, int[] nums2) {
  //     long res = 0;
  //     for (long n : nums1)
  //         res += twoProduct(n * n, nums2);
  //     for (long n : nums2)
  //         res += twoProduct(n * n, nums1);
  //     return (int)res;
  // }
  // long twoProduct(long i, int[] n) {
  //     Map<Long, Long> m = new HashMap<>();
  //     long cnt = 0;
  //     for (long v : n) {
  //         if (i % v == 0)
  //             cnt += m.getOrDefault(i / v, 0l);
  //         m.put(v, m.getOrDefault(v, 0l) + 1);
  //     }
  //     return cnt;
  // }
}
