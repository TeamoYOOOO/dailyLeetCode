import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    backtrack(s, 0, res, new ArrayList<>());
    return res;
  }

  private void backtrack(String s, int pos, List<List<String>> res, List<String> l){
    if(pos == s.length()){
      res.add(new ArrayList<>(l));//注意这里不能res.add(l); 因为l始终都是一节 一直跟着backtracking变 需要add deep copy
    }
    else{
      for(int x = pos; x < s.length(); x++){
        if(isPal(s, pos, x)){
          l.add(s.substring(pos, x+1));
          backtrack(s, x+1, res, l);
          l.remove(l.size()-1);
        }
      }
    }

  }

  private boolean isPal(String s, int low, int high){
    while(low < high){
      if(s.charAt(low) != s.charAt(high)) return false;
      low++;high--;
    }
    return true;
  }

}
