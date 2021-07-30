public class FindTheCelebrity {
  public int findCelebrity(int n) {
    //答案
    int candidate = 0;
    for(int i = 1; i < n; i++){
      if(knows(candidate, i))
        candidate = i;
    }
    //不需要担心顺序 因为如果cdd2直接跳到4 说明3是2不认识的 那肯定3不会是celebrity所以就算每轮i都++ 只要数字不是一个个上去的就说明那些跳过的数字一定是有人不认识的一定不是celebrity
    for(int i = 0; i < n; i++){
      if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
    }
    return candidate;



    // List<Integer> l = new ArrayList<>();
    // for(int x = 0; x < n; x++){
    //     for(int y = 0; y < n; y++){
    //         if(x != y){
    //             if(knows(x, y)){
    //                 break;
    //             }
    //         }
    //         if(y == n-1) l.add(x);
    //     }
    // }
    // for(int x = 0; x < l.size(); x++){
    //     int i = l.get(x);
    //     for(int y = 0; y < n; y++){
    //         if(!knows(y, i)) break;
    //         if(y == n-1) return i;
    //     }
    // }
    // return -1;



    // HashMap<Integer, Integer> known = new HashMap<>();//被知道的次数 次数应该是n-1
    // HashSet<Integer> know = new HashSet<>();//知道别人 只要有 就不是celebrity
    // for(int x = 0; x < n; x++){
    //     for(int y = 0; y < n; y++){
    //         if(x != y){
    //             if(knows(x, y)){
    //                 known.put(y, known.getOrDefault(y, 0)+1);
    //                 know.add(x);
    //             }
    //         }
    //     }
    // }
    // for(int x = 0; x < n; x++){
    //     if(known.containsKey(x) && known.get(x) == n-1 && !know.contains(x)) return x;
    // }
    // return -1;
  }
}
