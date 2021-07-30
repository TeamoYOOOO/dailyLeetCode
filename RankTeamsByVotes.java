public class RankTeamsByVotes {
  public String rankTeams(String[] votes) {
    int len = votes[0].length();
    int[][] map = new int[26][len + 1];
    for(int i = 0; i < 26; i++) map[i][len] = i;

    for(int i = 0; i < votes.length; i++){
      String s = votes[i];
      for(int j = 0; j < len; j++){
        map[s.charAt(j) - 'A'][j]++;
      }
    }
    Arrays.sort(map, (a, b) ->{
      for(int i = 0; i < len; i++){
        if(a[i] < b[i]) return 1;
        if(a[i] > b[i]) return -1;
      }
      return 0;
    });
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < len; i++){
      sb.append((char)('A' + map[i][len]));
    }
    return sb.toString();

//         Map<Character, int[]> map = new HashMap<>();
//         int l = votes[0].length();
//         for(String vote : votes){
//             for(int i = 0; i < l; i++){
//                 char c = vote.charAt(i);
//                 map.putIfAbsent(c, new int[l]);
//                 map.get(c)[i]++;
//             }
//         }

//         List<Character> list = new ArrayList<>(map.keySet());
//         Collections.sort(list, (a,b) -> {
//             for(int i = 0; i < l; i++){
//                 if(map.get(a)[i] != map.get(b)[i]){
//                     return map.get(b)[i] - map.get(a)[i];
//                 }
//             }
//             return a - b;
//         });

//         StringBuilder sb = new StringBuilder();
//         for(char c : list){
//             sb.append(c);
//         }
//         return sb.toString();
  }
}
