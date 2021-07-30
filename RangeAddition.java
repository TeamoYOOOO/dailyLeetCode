public class RangeAddition {
  public int[] getModifiedArray(int length, int[][] updates) {
    int[] res = new int[length];
    for(int[] update : updates) {
      int value = update[2];
      int start = update[0];
      int end = update[1];

      res[start] += value;
      if(end < length - 1)
        res[end + 1] -= value;
    }

    int sum = 0;
    for(int i = 0; i < length; i++) {
      sum += res[i];
      res[i] = sum;
    }

    return res;

    // int[] res = new int[length];
    // for(int x = 0; x < updates.length; x++){
    //     int start = updates[x][0];
    //     int end = updates[x][1];
    //     int inc = updates[x][2];
    //     for(int y = start; y <= end; y++){
    //         res[y]+=inc;
    //     }
    // }
    // return res;
  }
}
