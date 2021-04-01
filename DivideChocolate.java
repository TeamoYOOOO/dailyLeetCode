public class DivideChocolate {
  public int maximizeSweetness(int[] sweetness, int K) {
    int l = Integer.MAX_VALUE, r = 0;
    for(int x = 0; x < sweetness.length; x++){
      r += sweetness[x];
      l = Math.min(sweetness[x], l);
    }
    int res = 0;
    if(sweetness.length == K+1) return l;
    while(l < r){
      int mid = l + (r-l)/2;
      int min = r;
      int sum = 0;
      int count = 0;//count是0不是1因为检查count++在后面 最后一位也会考虑到
      for(int i : sweetness){
        sum+=i;
        if(sum >= mid){
          count++;
          min = Math.min(sum, min);
          sum = 0;
        }
      }
      if(count <= K){//count要>=K+1
        r = mid;
      }else{
        res = Math.max(min, res);
        l = mid+1;
      }
    }
    return res;//不能return l
  }
}
