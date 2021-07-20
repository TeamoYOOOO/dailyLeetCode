public class SubarraySumsDivisibleByK {
  public int subarraysDivByK(int[] A, int K) {
    int[] hm = new int[K];
    int sum = 0, res = 0; hm[0] = 1;
    for(int x = 0; x < A.length; x++){
      sum = ((sum+A[x])%K+K)%K;//(sum+A[x]+K)%K;不能这么写 因为A[x]负数可能是K很多倍 这样还是负的. -7%5 = -2 所以要先mod再加再mode
      res += hm[sum];
      hm[sum]++;
    }
    return res;

    //可以用array代替HM 更快
    // int[] map = new int[K];
    // map[0] = 1;
    // int count = 0, sum = 0;
    // for(int a : A) {
    // sum = (sum + a) % K;
    // if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
    // count += map[sum];
    // map[sum]++;
    // }
    // return count;

    //如果负的就变成正的 这样只需要检查是不是遇到之前同样的数 就等于保证真个区间%是0
    // Map<Integer, Integer> hm = new HashMap<>();
    // int sum = 0, res = 0; hm.put(0, 1);
    // for(int x = 0; x < A.length; x++){
    //     sum = (sum + A[x])% K;
    //     if(sum < 0) sum+= K;
    //     res += hm.getOrDefault(sum, 0);
    //     hm.put(sum, hm.getOrDefault(sum, 0)+1);
    // }
    // return res;

    //如果不管正负就可能出现三种情况 所以要检查sum, sum+K, sum-K
    // Map<Integer, Integer> hm = new HashMap<>();
    // int sum = 0, res = 0; hm.put(0, 1);
    // for(int x = 0; x < A.length; x++){
    //     sum = (sum + A[x])% K;
    //     res += hm.getOrDefault(sum, 0);
    //     res += hm.getOrDefault(sum + K, 0);
    //     res += hm.getOrDefault(sum - K, 0);
    //     hm.put(sum, hm.getOrDefault(sum, 0)+1);
    // }
    // return res;
  }
}
