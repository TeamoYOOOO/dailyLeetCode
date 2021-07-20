public class MaxChunksToMakeSorted {
  //类似quick sort思想
  public int maxChunksToSorted(int[] arr) {
    if (arr == null || arr.length == 0) return 0;

    int count = 0, max = 0;
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
      //！！！
      if (max == i) {//注意是i 这就是下面的为什么错了 题目是0到n-1
        count++;
      }
    }

    return count;
  }
  //对于这个问题，这个算法要我们做的是找到一些分裂线，这样这条线左边的数字都小于这条线右边的数字。这个想法与快速排序非常相似。这个问题的答案是你可以找到多少行。这就是为什么我们想要max数组，或者我们只需要一个数字来存储到目前为止的最大数（因为原始数组是0到len-1），只要最大数等于索引，我们知道到此为止的所有数字都小于此点，此时的数字大于此点，然后我们计算加1。
  //The key to understand this algorithms lies in the fact that when max[index] == index, all the numbers before index must be smaller than max[index] (also index), so they make up of a continuous unordered sequence, i.e {0,1,..., index}. This is because numbers in array only vary in range [0, 1, ..., arr.length - 1], so the most numbers you can find that are smaller than a certain number, say arr[k], would be arr[k] - 1, i.e [0, 1, ..., arr[k] - 1]. So when arr[k] is the max number in [arr[0], arr[1], ..., arr[k]], all the k - 1 numbers before it can only lies in [0, 1, ..., arr[k] - 1], so they made up of a continuous sequence. (You can also prove it using contradiction, which may be easier to understand)

  //错的
  // public int maxChunksToSorted(int[] arr) {
  //     int max = arr[0], count = 1;
  //     for(int x = 0; x < arr.length; x++){
  //         if(arr[x] > max){
  //             count++;
  //             max = arr[x];
  //         }
  //     }
  //     return count;
  // }
}
}
