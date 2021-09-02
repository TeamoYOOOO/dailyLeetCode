public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    // Arrays.sort(strs, (a,b) -> a.length() - b.length());
    // String first = strs[0];
    // int i = 1;
    // while(i <= first.length()){//<=!!!
    //     for(int x = 0; x < strs.length; x++){
    //         if(strs[x].indexOf(first.substring(0, i)) != 0){
    //             return first.substring(0, i-1);
    //         }
    //     }
    //     i++;
    // }
    // return first;

    // int minI = -1, minLen = Integer.MAX_VALUE;
    // for(int x = 0; x < strs.length; x++){
    //     if(strs[x].length() < minLen){
    //         minLen = strs[x].length();
    //         minI = x;
    //     }
    // }
    // int i = 1;
    // while(i <= strs[minI].length()){//<=!!!
    //     for(int x = 0; x < strs.length; x++){
    //         if(strs[x].indexOf(strs[minI].substring(0, i)) != 0){
    //             return strs[minI].substring(0, i-1);
    //         }
    //     }
    //     i++;
    // }
    // return strs[minI];


    //最快
    int minI = -1, minLen = Integer.MAX_VALUE;
    for(int x = 0; x < strs.length; x++){
      if(strs[x].length() < minLen){
        minLen = strs[x].length();
        minI = x;
      }
    }
    for(int x = strs[minI].length(); x >= 0; x--){
      for(int y = 0; y < strs.length; y++){
        if(strs[y].length() < x || strs[y].indexOf(strs[minI].substring(0,x)) != 0)//不能用contains因为必须是prefix
          break;
        if(y == strs.length-1) return strs[minI].substring(0,x);//minI注意index是啥
      }
    }
    return "";
  }
}
