public class SubstringOfSizeThreeWithDistinctCharacters {
  public int countGoodSubstrings(String s) {
    // int[] hm = new int[26];
    // int l = 0, r = 0;
    // int total = 0, count = 0, res = 0;
    // while(r < s.length()){
    //     char c = s.charAt(r);
    //     hm[c - 'a']++;
    //     total++;
    //     if(hm[c-'a'] == 1) count++;
    //     if(total == count && r-l+1 == 3) res++;
    //     while(r - l >= 3){//重点不是total == count 而是保持window的范围是3 r-l==3是4个数
    //         hm[s.charAt(l) - 'a']--;
    //         total--;
    //         if(hm[s.charAt(l) - 'a'] == 0) count--;
    //         l++;
    //         if(total == count && r-l+1 == 3) res++;
    //     }
    //     r++;
    // }
    // return res;

    // int[] hm = new int[26];
    // int l = 0, r = 0;
    // int repeat = 0, res = 0;//可以直接用repeat代替两个var
    // while(r < s.length()){
    //     char c = s.charAt(r);
    //     hm[c - 'a']++;
    //     if(hm[c-'a'] == 2) repeat++;
    //     if(repeat == 0 && r-l+1 == 3) res++;
    //     while(r - l >= 3){//重点不是total == count 而是保持window的范围是3 r-l==3是4个数
    //         hm[s.charAt(l) - 'a']--;
    //         if(hm[s.charAt(l) - 'a'] == 1) repeat--;
    //         l++;
    //         if(repeat == 0 && r-l+1 == 3) res++;
    //     }
    //     r++;
    // }
    // return res;

    int[] hm = new int[26];
    int l = 0, r = 0;
    int repeat = 0, res = 0;
    while(r < s.length()){
      char c = s.charAt(r);
      hm[c - 'a']++;
      if(hm[c-'a'] == 2) repeat++;
      if(r - l >= 3){//重点不是total == count 而是保持window的范围是3 r-l==3是4个数
        hm[s.charAt(l) - 'a']--;
        if(hm[s.charAt(l) - 'a'] == 1) repeat--;
        l++;
      }
      if(repeat == 0 && r-l+1 == 3) res++;//因为是要求window长度 所以上面可以写if不用谢while 每次最多挪一个l 只要在这检查是不是满足要求就行
      r++;
    }
    return res;
  }
}
