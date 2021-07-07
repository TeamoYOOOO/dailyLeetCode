public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    int[] hm = new int[128];//hashmap 注意是character！！不一定是字母 len是128不是26
    int l = 0, r = 0, count = 0, max = 0;
    while(r < s.length()){
      char c = s.charAt(r);
      if(hm[c] > 0){
        count++;
      }
      hm[c]++;//还是需要知道多少个的 所以要放外面
      while(count > 0){
        hm[s.charAt(l)]--;
        if(hm[s.charAt(l)] == 1){//!!!!这里是==1 不是<=1 因为只考虑原本超过1个 现在变成1个的 代表有repeat的数字少了一个 但是如果是<=1原来是distinct的去掉也会更新count就不对了
          count--;
        }
        // max = Math.max(max, r-l+1);//这里是不满足的情况 应该放外面检查
        l++;
      }
      max = Math.max(max, r-l+1);//这里才是一定满足没有repeat char的///r之后更新就是r-l+1如果在这之前就是r-l
      r++;
    }
    return max;
  }
}
