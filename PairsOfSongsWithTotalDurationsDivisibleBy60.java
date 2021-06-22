public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
  public int numPairsDivisibleBy60(int[] time) {
    int[] hm = new int[60];
    for(int x = 0; x < time.length; x++){
      hm[(time[x]%60)]++;//不一定是10倍数
    }
    int zero = 0;
    for(int x = hm[0]-1; x > 0; x--){
      zero += x;
    }
    int thirty = 0;
    for(int x = hm[30]-1; x > 0; x--){//注意是30！ index本来就是从0开始的
      thirty += x;
    }
    int count = 0;
    int l = 1, r = hm.length-1;
    while(l < r){
      count += hm[l]*hm[r];
      l++; r--;
    }
    return count + zero + thirty;
  }
}
