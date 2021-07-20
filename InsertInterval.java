public class InsertInterval {
  //hard coding的感觉 看看能不能改成一种写法满足所有
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int start = -1, end = -1;
    for(int x = 0; x < intervals.length; x++){
      if(start == -1 && intervals[x][1] >= newInterval[0]){
        start = x;
      }
      if(intervals[x][0] <= newInterval[1]){
        end = x;
      }
      if(intervals[x][0] > newInterval[1]) break;
    }
    int diff = start == -1? -1 : end-start, i = 0;//[[1,5]][6,8]
    int[][] res = new int[intervals.length-diff][2];
    if(start == -1){//如果start == -1代表所有的都比new intervals的小 不合并 [[1,5]][6,8]
      for(int x = 0; x < intervals.length; x++){
        res[i][0] = intervals[x][0];
        res[i][1] = intervals[x][1];
        i++;
      }
      res[i][0] = start == -1? newInterval[0] : Math.min(intervals[start][0], newInterval[0]);
      res[i][1] = end == -1? newInterval[1] : Math.max(intervals[end][1], newInterval[1]);
    }else{
      for(int x = 0; x < start; x++){
        res[i][0] = intervals[x][0];
        res[i][1] = intervals[x][1];
        i++;
      }
      res[i][0] = start == -1? newInterval[0] : Math.min(intervals[start][0], newInterval[0]);
      res[i][1] = end == -1? newInterval[1] : Math.max(intervals[end][1], newInterval[1]);
      i++;
      for(int x = i; x < res.length; x++){
        res[i][0] = intervals[i+diff][0];
        res[i][1] = intervals[i+diff][1];
        i++;
      }
    }
    return res;
  }
}
