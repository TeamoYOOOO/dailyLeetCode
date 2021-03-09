import java.util.Arrays;

public class MeetingRoom {
  public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, (a,b) -> a[1] - b[1]);//a[0] - b[0]也可以
    for(int x = 0; x < intervals.length-1; x++){
      if(intervals[x][1] > intervals[x+1][0]) return false;
    }
    return true;
  }
}
