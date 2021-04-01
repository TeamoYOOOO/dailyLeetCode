public class CapacityToShipPackagesWithinDDays {
  public int shipWithinDays(int[] weights, int D) {
    int l = 1, r = 0;
    for(int x = 0; x < weights.length; x++){
      r += weights[x];
    }
    while(l < r){
      int mid = l + (r-l)/2;
      int count = 1;
      int w = 0;
      for(int i : weights){
        if(i > mid){//要考虑大于mid的货物装不下的情况
          count = -1;
          break;
        }
        if(w + i > mid){
          count++;
          w = i;
        }else{
          w += i;
        }
      }
      if(count > D || count == -1){//有装不下的情况和次数过多的 找右半边
        l = mid + 1;
      }else{
        r = mid;
      }
    }
    return l;
  }
}
