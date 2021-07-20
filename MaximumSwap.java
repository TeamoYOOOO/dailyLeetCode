public class MaximumSwap {
  public int maximumSwap(int num) {
    //自己写的  O(NLOGN)因为要sort 有更好的写法
    // List<Integer> sorted = new ArrayList<>();
    // while(num > 0){
    //     sorted.add(0, num%10);
    //     num = num/10;
    // }
    // List<Integer> unsorted = new ArrayList<>(sorted);
    // Collections.sort(sorted, (a,b) -> b-a);
    // for(int x = 0; x < sorted.size(); x++){
    //     if(unsorted.get(x) != sorted.get(x)){
    //         int temp = unsorted.get(x);
    //         //优先调用后面的这个数字因为这样可以让数字更大 把后面的大数字移到前面 前面的大数字(if applicable 留着)
    //         int i = unsorted.lastIndexOf(sorted.get(x));//lastIndexOf!!!!
    //         unsorted.set(x, sorted.get(x));
    //         unsorted.set(i, temp);
    //         break;
    //     }
    // }
    // int res = 0;
    // for(int x = 0; x < unsorted.size(); x++){
    //     res *= 10;
    //     res += unsorted.get(x);
    // }
    // return res;


    //答案---思路一样但是省了用两个list还sort了 这个O(N)
    char[] s = String.valueOf(num).toCharArray();
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length; i++) {
      map.put(s[i] - '0', i);
    }

    for (int i = 0; i < s.length; i++) {
      int currVal = s[i] - '0';
      for (int j = 9; j >= 0; j--) {

        if (map.containsKey(j) && j > currVal && map.get(j) > i) {
          s[i] = (char)(j + '0');
          int index = map.get(j);
          s[index] = (char)(currVal + '0');

          return Integer.valueOf(new String(s));

        }
      }
    }


    return num;
  }
}
