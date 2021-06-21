public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
    List<int[]> res = new ArrayList<>();
    int start = intervals[0][0], end = intervals[0][1];
    for(int x = 1; x < intervals.length; x++){
      if(intervals[x][0] <= end){
        end = Math.max(end, intervals[x][1]);
      }else{
        res.add(new int[]{start, end});
        start = intervals[x][0];
        end = intervals[x][1];
      }
    }
    res.add(new int[]{start, end});
    int[][] ans = new int[res.size()][2];
    for(int x = 0; x < ans.length; x++){
      ans[x][0] = res.get(x)[0];
      ans[x][1] = res.get(x)[1];
    }
    return ans;
  }
}
