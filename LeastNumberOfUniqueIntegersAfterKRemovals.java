public class LeastNumberOfUniqueIntegersAfterKRemovals {
  //--------------------OLOGN SORT-----------------------
  // public int findLeastNumOfUniqueInts(int[] arr, int k) {
  //     //这一题不能用int[] 代替hm因为arr[i]最多10^9 这样就不能sort了
  //     HashMap<Integer,Integer> hm = new HashMap<>();
  //     for(int x = 0; x < arr.length; x++){
  //         hm.put(arr[x], hm.getOrDefault(arr[x], 0)+1);
  //     }
  //     List<Integer> l = new ArrayList<>(hm.keySet());
  //     Collections.sort(l, (a,b)->hm.get(a)-hm.get(b));//放key 根据value来sort
  //     int i = 0, curr = hm.get(l.get(i));
  //     //这种一次-k 不用一个个减快一点 但是这样i会挪到下一个 最后需要检查前一个减完k是不是负数 是的话加上前面 这个会比下面那个i多挪一位 所以结局是l.size()-i+1和l.size()-i
  //     while(k > 0){
  //         k -= curr;
  //         i++;
  //         if(i == l.size()) return k < 0? 1 : 0;//正好所有的都remove完 - 这种写法 得在这检查 不然out of bound - 而且需要检查k是不是<0 小于零可能就是最后一位还有多久 要return1 case: [1,1] 1
  //         curr = hm.get(l.get(i));
  //     }
  //     return k < 0? l.size()-i+1:l.size()-i;//如果当前数字的还没remove完 就要多算一个
  //     //这个是一个个减的 i在前面一位 最后检查return的是l.size()-i和l.size()-i-1
  //     // while(k > 0){
  //     //     if(curr == 0){
  //     //         i++;
  //     //         curr = hm.get(l.get(i));
  //     //     }
  //     //     curr--;
  //     //     k--;
  //     // }
  //     // if(i == l.size()) return 0;//正好所有的都remove完
  //     // return curr>0? l.size()-i:l.size()-i-1;//如果当前数字的还没remove完 就要多算一个
  // }


  //--------------------O(N)--------------------------
  //直接用value来做一个array(hm) 记录每个次数分别有多少个 从小到大遍历减 最后遍历剩下的算数量就好
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    //这一题不能用int[] 代替hm因为arr[i]最多10^9 这样就不能sort了
    HashMap<Integer,Integer> hm = new HashMap<>();
    for(int x = 0; x < arr.length; x++){
      hm.put(arr[x], hm.getOrDefault(arr[x], 0)+1);
    }
    int[] count = new int[Collections.max(hm.values())+1];
    for(int i: hm.values()){
      count[i]++;
    }
    int i = 0;
    while(k > 0){
      if(count[i] > 0){
        k -= i;
        count[i]--;
      }else{
        i++;
      }
    }
    int res = 0;
    for(int x = i; x < count.length; x++){
      res += count[x];
    }
    return k < 0? res+1: res;//如果k是负的 最后一次减的那个数也得算上
  }
}
