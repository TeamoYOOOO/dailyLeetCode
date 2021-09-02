public class MaximumNumberOfWordsYouCanType {
  public int canBeTypedWords(String text, String brokenLetters) {
    String[] strs = text.split(" ");
    // HashSet<Character> hs = new HashSet<>();
    // for(int x = 0; x < brokenLetters.length(); x++){
    //     hs.add(brokenLetters.charAt(x));
    // }
    boolean[] hs = new boolean[26];
    for(int x = 0; x < brokenLetters.length(); x++){
      hs[brokenLetters.charAt(x) - 'a'] = true;
    }
    int count = 0;
    for(int x = 0; x < strs.length; x++){
      for(int y = 0; y < strs[x].length(); y++){
        if(hs[strs[x].charAt(y)-'a']) break;
        if(y == strs[x].length()-1) count++;
      }
    }
    return count;
  }
}
