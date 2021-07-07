public class SubarraysWithKDifferentIntegers {
  public int subarraysWithKDistinct(int[] A, int K) {
    return atMost(A, K) - atMost(A, K-1);
  }
  private int atMost(int[] A, int k){
    int l = 0, r = 0, res = 0, count = 0;
    int[] hm = new int[A.length+1];//+1为了懒得-1
    while(r < A.length){
      if(hm[A[r]] == 0) count++;
      hm[A[r]]++;
      while(count > k){
        hm[A[l]]--;
        if(hm[A[l]] == 0) count--;
        l++;
      }
      // if(count == k) res++;
      res += r-l+1;
      r++;
    }
    return res;
  }

  // public int subarraysWithKDistinct(int[] A, int K) {
  //     return atMost(A, K) - atMost(A, K-1);
  // }
  // private int atMost(int[] A, int k){
  //     int l = 0, r = 0, res = 0, count = 0;
  //     HashMap<Integer, Integer> hm = new HashMap<>();
  //     while(r < A.length){
  //         if(!hm.containsKey(A[r]) || hm.get(A[r]) == 0) count++;//!!0也有可能因为会减
  //         hm.put(A[r], hm.getOrDefault(A[r], 0)+1);
  //         while(count > k){
  //             hm.put(A[l], hm.get(A[l])-1);
  //             if(hm.get(A[l]) == 0) count--;
  //             l++;
  //         }
  //         // if(count == k) res++;
  //         res += r-l+1;
  //         r++;
  //     }
  //     return res;
  // }
}
