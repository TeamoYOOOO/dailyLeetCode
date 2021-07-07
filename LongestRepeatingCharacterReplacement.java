public class LongestRepeatingCharacterReplacement {
  public int characterReplacement(String s, int k) {
    int len = s.length();
    int[] count = new int[26];
    int l = 0, maxCount = 0, maxLength = 0;
    for (int r = 0; r < len; r++) {
      maxCount = Math.max(maxCount, ++count[s.charAt(r) - 'A']);
      while (r - l + 1 - maxCount > k) {
        count[s.charAt(l) - 'A']--;
        l++;
      }
      maxLength = Math.max(maxLength, r - l + 1);
    }
    return maxLength;
  }
}
