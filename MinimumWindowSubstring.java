public class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    if(s.length() < t.length()) return "";//edge case
    int l = 0, r = 0, count = 0;
    int[] hm = new int[128];//uppercase and lowercase English letters
    for(int x = 0; x < t.length(); x++){
      if(hm[t.charAt(x)]++ == 0) count++;
    }
    int min = Integer.MAX_VALUE, start = -1, end = -1;
    while(r < s.length()){
      hm[s.charAt(r)]--;
      if(hm[s.charAt(r)] == 0) count--;
      while(count <= 0){
        if(r-l+1 < min){
          min = r-l+1;
          start = l;
          end = r+1;
        }
        hm[s.charAt(l)]++;
        if(hm[s.charAt(l)] > 0)count++;
        l++;
      }
      r++;
    }
    return min == Integer.MAX_VALUE? "" : s.substring(start,end);//edge case
  }
}
