import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {
  public int minMeetingRooms(int[][] intervals) {
    if(intervals.length == 0){return 0;}
    //根据start time来sort
    Arrays.sort(intervals, new Comparator<int[]>(){
      public int compare(int[] i1, int[] i2){
        return i1[0] - i2[0];
      }
    });
    //PQ里根据end time来peek/poll 每次比较最小的end time和现在的start time 如果end > start就意味着需要加一个新的room ！！！
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
      public int compare(Integer i1, Integer i2){
        return i1 - i2;
      }
    });
    //先把第一个数加进去 算room1
    pq.add(intervals[0][1]);
    //从第二个数开始比较 如果end <= start就说明不需要多加一个room 可以poll上一个房间 反之需要新的房间
    for(int x = 1; x < intervals.length; x++){
      // System.out.println(pq.peek());
      if(pq.peek() <= intervals[x][0]){
        pq.poll();
      }
      pq.add(intervals[x][1]);
    }
    return pq.size();
  }
}
