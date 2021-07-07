public class FindAllAnagramsInAString {
  public List<Integer> findAnagrams(String s, String p) {
    int count = 0, l = 0, r = 0;
    HashMap<Character, Integer> hm = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    for(int x = 0; x < p.length(); x++){
      if(!hm.containsKey(p.charAt(x))) count++;
      hm.put(p.charAt(x), hm.getOrDefault(p.charAt(x), 0)+1);
    }
    while(r < s.length()){
      char c =  s.charAt(r);
      if(hm.containsKey(c)){
        hm.put(c, hm.get(c)-1);
        if(hm.get(c) == 0) count--;
      }
      // if(count == 0 && r-l+1 == p.length()) res.add(l);不能写这 case: "cbaebabacd" "abc"
      // while(count == 0 || r-l+1 > p.length()){也可以 下面那个合理一点
      while(r-l+1 >= p.length()){//fixed window size
        if(count == 0 && r-l+1 == p.length()) res.add(l);
        char ll = s.charAt(l);
        l++;
        if(hm.containsKey(ll)){
          if(hm.get(ll) == 0) count++;
          hm.put(ll, hm.get(ll)+1);
        }
      }
      r++;
    }
    return res;
  }
}
