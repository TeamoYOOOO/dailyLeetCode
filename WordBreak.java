public class WordBreak {
  public boolean wordBreak(String s, List<String> dict) {
    Queue<String> q = new LinkedList<>();
    HashSet<String> visited  = new HashSet<>();//需要一个visited来记录走过的 不然会有很多重复 浪费时间
    q.add(s);
    while(!q.isEmpty()){
      String curr = q.poll();
      if(visited.contains(curr)) continue;
      for(int x = 0; x < dict.size(); x++){
        if(curr.equals(dict.get(x))) return true;
        if(curr.startsWith(dict.get(x))){
          q.add(curr.substring(dict.get(x).length()));
        }
      }
      visited.add(curr);
    }
    return false;
  }


  //--------------dfs TLE 得用queue才能真正的实现bfs------------
  // public boolean wordBreak(String s, List<String> dict) {
  //     if(s.length() == 0) return true;
  //     boolean res = false;
  //     for(int x = 0; x < dict.size(); x++){
  //         if(s.startsWith(dict.get(x))){
  //             res = res || wordBreak(s.substring(dict.get(x).length()), dict);
  //             if(res) return res;
  //         }
  //     }
  //     return res;
  // }
}
