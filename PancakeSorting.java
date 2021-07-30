public class PancakeSorting {
  public List<Integer> pancakeSort(int[] A) {
    List<Integer> res = new ArrayList<>();
    for(int x = A.length; x > 0; x--){
      int i = -1;
      for(int y = 0; y < A.length; y++){
        if(A[y] == x){
          i = y;
          break;
        }
      }
      if(i != x-1){
        if(i != 0){//不写应该也行 不过如果这个数就在第一个 就不如要先翻转让他到第一位了
          flip(A, i);//翻转让下一个最大值到第一位到第一位了
          res.add(i+1);//注意不是index是多少位数 所以要+1
        }
        if(A[x-1] == x) break;
        flip(A, x-1);//x-1!!  翻转下一个最大数到对应的位置
        res.add(x);//x-1+1=x -> -1是数字对应index要-1 但是因为要的是位数所以+1
      }
    }
    return res;
  }
  private void flip(int[] arr, int end){
    for(int x = 0; x <= end/2; x++){//<=!!
      int temp = arr[x];
      arr[x] = arr[end-x];
      arr[end-x] = temp;
    }
  }
}
