public class SortCharactersByFrequency {
  //--------hashmap + bucket sort--------
  public String frequencySort(String s) {
    HashMap<Character, Integer> hm = new HashMap<>();
    for(char c : s.toCharArray()){
      hm.put(c,hm.getOrDefault(c, 0)+1);
    }
    int max = Collections.max(hm.values());
    List<List<Character>> l = new ArrayList<>();
    for(int x = 0; x <= max; x++){//0-max (max+1)个
      l.add(new ArrayList<Character>());
    }
    for(Character c : hm.keySet()){
      l.get(hm.get(c)).add(c);
    }
    StringBuilder sb = new StringBuilder();
    for(int x = l.size()-1; x > 0; x--){//0不需要加
      for(int y = 0; y < l.get(x).size(); y++){
        for(int z = 0; z < x; z++){
          sb.append(l.get(x).get(y));
        }
      }
    }
    return sb.toString();
  }

  //------------hashmap + sort-----------
  // public String frequencySort(String s) {
  //     HashMap<Character, Integer> hm = new HashMap<>();
  //     for(char c : s.toCharArray()){
  //         hm.put(c,hm.getOrDefault(c, 0)+1);
  //     }
  //     List<Character> l = new ArrayList<>(hm.keySet());
  //     Collections.sort(l, (a, b) -> hm.get(b)-hm.get(a));
  //     StringBuilder sb = new StringBuilder();
  //     for(int x = 0; x < l.size(); x++){
  //         for(int y = 0; y < hm.get(l.get(x)); y++){
  //             sb.append(l.get(x));
  //         }
  //     }
  //     return sb.toString();
  // }  
}
