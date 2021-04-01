public class MinimumNumberOfDaysToMakeMBouquets {
  public int minDays(int[] bloomDay, int m, int k) {
    if (m * k > bloomDay.length) return -1;
    int l = 1, r = 0;
    for(int x = 0; x < bloomDay.length; x++){
      r = Math.max(bloomDay[x], r);
    }
    while(l < r){
      int mid = l + (r-l)/2;
      int count = 0;
      int con = 0;
      for(int x = 0; x < bloomDay.length; x++){
        if(bloomDay[x] <= mid){
          con++;
        }else{
          con = 0;
        }
        if(con == k){
          count++;
          con = 0;
        }
      }
      if(count < m){
        l = mid+1;
      }else{
        r = mid;
      }
    }
    return l;
  }
}
