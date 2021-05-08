public class JumpGame4 {
  //bfs
  public int minJumps(int[] arr) {
    Queue<Integer> q = new LinkedList<>();
    HashMap<Integer, List<Integer>> hm = new HashMap<>();
    int n = arr.length;
    boolean[] visited = new boolean[n];
    q.add(n-1); visited[n-1] = true;
    int step = 0;
    for(int x = 0; x < n; x++){
      hm.computeIfAbsent(arr[x], y -> new LinkedList<>()).add(x);//works the same
      // if(hm.containsKey(arr[x])){
      //     hm.get(arr[x]).add(x);
      // }else{
      //     List<Integer> l = new ArrayList<>();
      //     l.add(x);
      //     hm.put(arr[x], l);
      // }
    }
    while(!q.isEmpty()){
      for(int x = q.size(); x > 0; x--){
        int i = q.poll();
        if(i == 0) return step;
        hm.get(arr[i]).add(i-1);hm.get(arr[i]).add(i+1);
        if(hm.containsKey(arr[i])){
          for(Integer index : hm.get(arr[i])){
            if(index >= 0 && index < n && !visited[index]){
              visited[index] = true;
              q.add(index);
            }
          }
        }
        hm.get(arr[i]).clear();
      }
      step++;
    }
    return step;
  }
}
