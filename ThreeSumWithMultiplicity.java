public class ThreeSumWithMultiplicity {
  public int threeSumMulti(int[] A, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    int res = 0;
    int mod = 1000000007;
    for (int i = 0; i < A.length; i++) {
      res = (res + map.getOrDefault(target - A[i], 0)) % mod;//hm找跟当前差的pair的数量

      for (int j = 0; j < i; j++) {//记录当前和前面的每个的pair 放入hm
        int temp = A[i] + A[j];
        map.put(temp, map.getOrDefault(temp, 0) + 1);
      }
    }
    return res;
  }
}
