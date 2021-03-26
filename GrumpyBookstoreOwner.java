public class GrumpyBookstoreOwner {
  public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    int l = 0, r = 0;
    int count = 0, total = 0, max = 0;
    int res = 0;
    while(r < customers.length){
      if(count < X){
        if(grumpy[r] == 0){
          res += customers[r];
        }
        else{
          total += customers[r];
        }
        count++;
        r++;
      }else{
        max = Math.max(total, max);
        total -= grumpy[l] == 0? 0 : customers[l];
        count--;
        l++;
        while(l < customers.length && grumpy[l] == 0){//!!!!l index!
          count--;
          l++;
        }
      }
    }
    max = Math.max(total, max);//!!!
    return res + max;
  }
}
