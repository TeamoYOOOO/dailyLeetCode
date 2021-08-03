public class MaximizeDistanceToClosestPerson {
  public int maxDistToClosest(int[] seats) {
    //lee的答案 O(N)time O(1)space 就是除了头尾跟第一个1的距离 其他是两个1之间/2的距离 找最大
    int res = 0, n = seats.length, last = -1;
    for (int i = 0; i < n; ++i) {
      if (seats[i] == 1) {
        res = last < 0 ? i : Math.max(res, (i - last) / 2);
        last = i;
      }
    }
    res = Math.max(res, n - last - 1);
    return res;


    //用两遍遍历来代替list记录的所有1的index
    // int[] max = new int[seats.length];
    // int prev = -1;
    // for(int x = 0; x < max.length; x++){
    //     if(seats[x] == 1){
    //         prev = x;
    //     }else{
    //         if(prev == -1){
    //             max[x] = Integer.MAX_VALUE;//从左到右遍历的时候第一个1之前的左边没有限制
    //         }else{
    //             max[x] = x-prev;
    //         }
    //     }
    // }
    // prev = -1; int res = 0;
    // for(int x = max.length-1; x >= 0; x--){
    //     if(seats[x] == 1){
    //         prev = x;
    //     }else{
    //         if(prev == -1){
    //             //从右到左的时候第一个1之前的右边也没有限制
    //             //因为左边的数字已经得到了 所以不需要做任何的操作 直接用左边的
    //             //等同于max[x] = Math.min(max[x], Integer.MAX_VALUE);
    //         }else{
    //             max[x] = Math.min(prev-x, max[x]);
    //         }
    //         res = Math.max(max[x], res);
    //     }
    // }
    // return res;



    //记录所有的1的index 然后遍历每次对比前后距离
    // List<Integer> occ = new ArrayList<>();
    // for(int x = 0; x < seats.length; x++){
    //     if(seats[x] == 1){
    //         occ.add(x);
    //     }
    // }
    // if(occ.size() == 1) return Math.max(seats.length-occ.get(0)-1, occ.get(0));
    // int max = 0, prev = -1, next = 0;
    // for(int x = 0; x < seats.length; x++){
    //     int left = prev == -1? -1: occ.get(prev);
    //     int right = next == occ.size()? -1: occ.get(next);
    //     if(x == right){//update prev/next
    //         prev = next;
    //         next++;
    //     }else{//check and update for max
    //         if(left == -1){//elements before first seat occupied - only check right
    //             max = Math.max(max,right-x);
    //         }else if(right == -1){//不能写next == occ.size()-1 case： [1,0,0,1]
    //             max = Math.max(max, x-left);//seats.length-x-1
    //         }else{
    //             max = Math.max(max, Math.min(x-left, right-x));
    //         }
    //     }
    // }
    // return max;
  }
}
