import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
  List<String> res = new ArrayList<>();
  public List<String> generateParenthesis(int n) {
    // List<String> res = new ArrayList<>();
    helper(0, 0, new StringBuilder(), n);
    return res;
  }

  public void helper(int open, int close, StringBuilder sb, int n){
    if(sb.length() == n*2){
      res.add(sb.toString());
    }
    if(open < n){
      sb.append("(");
      helper(open+1, close, sb, n);
      sb.setLength(sb.length()-1);
    }
    if(open > close){
      sb.append(")");
      helper(open, close+1, sb, n);
      sb.setLength(sb.length()-1);
    }
  }

}
