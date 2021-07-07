public class PermutationInString {
   //------------------自己写的------------------
   public boolean checkInclusion(String s1, String s2) {
       int[] hm = new int[26]; int count = 0;
       for(int x = 0; x < s1.length(); x++){
           hm[s1.charAt(x)-'a']++; count++;
       }
       int l = 0, r = 0;
       while(r < s2.length()){
           char c = s2.charAt(r);
           hm[c-'a']--;
           if(hm[c-'a'] >= 0) count--;//>= !!不是等于 那种不止一个的数都要考虑 因为正数只可能是s1里头需要的!! case: "abcdxabcde" "abcdeabcdx"
           while(r-l+1 > s1.length()){//fixed window?
               hm[s2.charAt(l)-'a']++;
               if(hm[s2.charAt(l)-'a'] > 0) count++;//从window移出去的只会从负数到0 正的话一定是差了s1里面的char
               l++;
           }
           if(count == 0) return true;
           r++;
       }
       return false;
   }

  //----------------------答案----------------------
//  public boolean checkInclusion(String s1, String s2) {
//    int len1 = s1.length(), len2 = s2.length();
//    if (len1 > len2) return false;
//
//    int[] count = new int[26];
//    for (int i = 0; i < len1; i++) {
//      count[s1.charAt(i) - 'a']++;
//      count[s2.charAt(i) - 'a']--;
//    }
//    if (allZero(count)) return true;
//
//    for (int i = len1; i < len2; i++) {
//      count[s2.charAt(i) - 'a']--;
//      count[s2.charAt(i - len1) - 'a']++;
//      if (allZero(count)) return true;
//    }
//
//    return false;
//  }
//
//  private boolean allZero(int[] count) {
//    for (int i = 0; i < 26; i++) {
//      if (count[i] != 0) return false;
//    }
//    return true;
//  }
}
