public class FindTheTownJudge {
  public int findJudge(int n, int[][] trust) {
    if(n == 1) return n;
    int[] known = new int[n];
    boolean[] know = new boolean[n];
    for(int x = 0; x < trust.length; x++){
      known[trust[x][1]-1]++;
      know[trust[x][0]-1] = true;
    }
    for(int x = 1; x <= n; x++){
      if(known[x-1] == n-1 && know[x-1] == false) return x;
    }
    return -1;
  }
}
