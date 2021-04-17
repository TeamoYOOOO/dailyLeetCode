public class ClimbingStairs {
  public int climbStairs(int n) {
    if(n == 1) return 1;
    if(n == 2) return 2;
    int[] mem = new int[n+1];
    mem[1] = 1;
    mem[2] = 2;
    for(int x = 3; x <= n; x++){
      mem[x] = mem[x-2] + mem[x-1];
    }
    return mem[n];
  }
}
