public class MaximumAreaOfaPieceOfCakeAfterHorizontalAndVerticalCuts {
  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    int m = horizontalCuts.length, n = verticalCuts.length;
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);
    int start = 0;
    long maxH = 0;
    for(int x = 0; x < m; x++){
      maxH = Math.max(maxH, horizontalCuts[x] - start);
      start = horizontalCuts[x];
    }
    maxH = Math.max(maxH, h - start);
    start = 0;
    long maxV = 0;
    for(int x = 0; x < n; x++){
      maxV = Math.max(maxV, verticalCuts[x] - start);
      start = verticalCuts[x];
    }
    maxV = Math.max(maxV, w - start);
    return (int)((maxH * maxV) % (1000000007));
  }
}
