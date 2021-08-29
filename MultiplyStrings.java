public class MultiplyStrings {
  public String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int[] pos = new int[m + n];

    for(int i = m - 1; i >= 0; i--) {
      for(int j = n - 1; j >= 0; j--) {
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); //一定是2位数
        int p1 = i + j, p2 = i + j + 1;
        //Start from right to left, perform multiplication on every pair of digits, and add them together. Let's draw the process! From the following draft, we can immediately conclude: `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]`
        int sum = mul + pos[p2];

        pos[p1] += sum / 10;//十位数 从后往前的 所以当前一定是0
        pos[p2] = (sum) % 10;//个位数 有上一个结果的十位数 所以sum前面要加Pos[p2]然后%
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
