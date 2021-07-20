public class MaxChunksToMakeSorted2 {
  // public int maxChunksToSorted(int[] arr) {
  //     int[] max = new int[arr.length];//当前index前最大值
  //     int[] min = new int[arr.length];//当前index后最小值
  //     for(int x = 0; x < arr.length; x++){
  //         if(x == 0){
  //             max[x] = arr[x];
  //         }else{
  //             max[x] = Math.max(arr[x], max[x-1]);
  //         }
  //     }
  //     for(int x = arr.length-1; x >= 0; x--){
  //         if(x == arr.length-1){
  //             min[x] = arr[x];
  //         }else{
  //             min[x] = Math.min(arr[x], min[x+1]);
  //         }
  //     }
  //     int count = 0;
  //     for(int x = 0; x < arr.length-1; x++){
  //         //其实就是想要分几个partition 满足的条件应该是这个分割线左边数全部比他小 右边全部比他大 所以直接比较max[x] min[x+1]就好 <=就是满足的 =也可以是因为 5 5 5 可以算3个 count得到的就是分割线的数量 最后return count+1 就是chunk的数量 区间=线+1 2条线 3个区间
  //         if(max[x] <= min[x+1]){//关键！！！！
  //             count++;
  //         }
  //     }
  //     return count+1;
  // }

  public int maxChunksToSorted(int[] arr) {
    int[] min = new int[arr.length];//当前index后最小值
    for(int x = arr.length-1; x >= 0; x--){
      if(x == arr.length-1){
        min[x] = arr[x];
      }else{
        min[x] = Math.min(arr[x], min[x+1]);
      }
    }
    int count = 0, max = Integer.MIN_VALUE;//可以省一次循环
    for(int x = 0; x < arr.length-1; x++){
      max = Math.max(max, arr[x]);
      if(max <= min[x+1]){//关键！！！！
        count++;
      }
    }
    return count+1;
  }
}
