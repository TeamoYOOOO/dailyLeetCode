public class KokoEatingBananas {
  public int minEatingSpeed(int[] piles, int h) {
    int l = 1, r = 1000000000;//r = 0
    // for(int x = 0; x < piles.length; x++){
    //     r = Math.max(r, piles[x]);
    // }
    while (l < r) {
      int m = (l + r) / 2, total = 0;
      for (int p : piles)
        total += (p + m - 1) / m;//equals to Math.ceil(p*1.0 / m)这个慢
      if (total > h)
        l = m + 1;
      else
        r = m;
    }
    return l;
  }
}
