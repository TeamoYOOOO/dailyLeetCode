public class CanMakePalindromeFromSubstring {
  //答案 看不懂
  public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
    List<Boolean> ans = new ArrayList<>();
    int[][] cnt = new int[s.length() + 1][26];
    for (int i = 0; i < s.length(); ++i) {
      cnt[i + 1] = cnt[i].clone(); // copy previous sum.
      ++cnt[i + 1][s.charAt(i) - 'a'];
    }
    for (int[] q : queries) {
      int sum = 0;
      for (int i = 0; i < 26; ++i) {
        sum += (cnt[q[1] + 1][i] - cnt[q[0]][i]) % 2;
      }
      ans.add(sum / 2 <= q[2]);
    }
    return ans;
  }

  //自己写的 beat 22%
  // public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
  //     List<Boolean> res = new ArrayList<>();
  //     List<int[]> hms = new ArrayList<>();
  //     int[] hm = new int[26];
  //     int len = s.length();
  //     hms.add(hm.clone());
  //     for(int x = 0; x < len; x++){
  //         hm[s.charAt(x)-'a']++;
  //         hms.add(hm.clone());
  //     }
  //     for(int x = 0; x < queries.length; x++){
  //         int start = queries[x][0];
  //         int end = queries[x][1]+1;
  //         int odd = 0;
  //         for(int y = 0; y < hm.length; y++){
  //             if((hms.get(end)[y] - hms.get(start)[y])%2 == 1) odd++;
  //         }
  //         res.add(odd/2 <= queries[x][2]);
  //     }
  //     return res;
  // }


  //需要prefix sum不然太慢了 TLE
  // private boolean helper(String s, int k){
  //     int[] hm = new int[26];
  //     int len = s.length();
  //     for(int x = 0; x < len; x++){
  //         hm[s.charAt(x)-'a']++;
  //     }
  //     int odd = 0;
  //     for(int x = 0; x < hm.length; x++){
  //         if(hm[x]%2 == 1) odd++;
  //     }
  //     return odd/2 <= k;//不用担心len长度技术还是偶数 技术的话odd/2 漏掉的那个1就等于是算放在中间的字母
  // }
  //又看错了 可以rerrange先！！
  // private boolean helper(String s, int k){
  //     for(int x = 0; x < s.length()/2; x++){
  //         int r = s.length()-x-1;
  //         if(s.charAt(x) != s.charAt(r)){
  //             k--;
  //         }
  //     }
  //     return k >= 0;
  // }
  //题目理解错了 以为是left-right最多可以修改k个让它变成palidrome
  // private boolean helper(String s, int start, int end, int k){
  //     for(int x = 0; x < s.length()/2; x++){
  //         int r = s.length()-x-1;
  //         if(s.charAt(x) != s.charAt(r)){
  //             if(x < start && r > end) return false;
  //             k--;
  //         }
  //     }
  //     return k >= 0;
  // }
}
