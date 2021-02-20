import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
  List<String> ans = new ArrayList<String>();
  public List<String> generateAbbreviations(String word){
    helper(new StringBuilder(), word, 0, 0);
    return ans;
  }

  private void helper(StringBuilder sb, String word, int i, int num){
    int len = sb.length();
    if(i == word.length()){
      if(num != 0)sb.append(num);
      ans.add(sb.toString());
    }else{
      helper(sb, word, i+1, num+1);

      if(num != 0) sb.append(num);
      sb.append(word.charAt(i));
      helper(sb, word, i+1, 0);
    }
    sb.setLength(len);
  }
}
