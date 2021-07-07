public class LongestSubstringWithAtMostKDistinctCharacters {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int[] hm = new int[128];//hashmap 注意是character！！不一定是字母 len是128不是26
    int l = 0, r = 0, count = 0, max = 0;
    while(r < s.length()){
      char c = s.charAt(r);
      if(hm[c] == 0){
        count++;
      }
      hm[c]++;//还是需要知道多少个的 所以要放外面
      while(count > k){
        hm[s.charAt(l)]--;
        if(hm[s.charAt(l)] == 0){
          count--;
        }
        // max = Math.max(max, r-l+1);//这里是不满足的情况 应该放外面检查
        l++;
      }
      max = Math.max(max, r-l+1);//这里才是一定满足<=k的distinct char的///r之后更新就是r-l+1如果在这之前就是r-l
      r++;
    }
    return max;
  }
}
