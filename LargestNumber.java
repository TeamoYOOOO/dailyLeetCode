public class LargestNumber {
  public String largestNumber(int[] nums) {
    String[] s = new String[nums.length];
    for(int x = 0; x < nums.length; x++){
      s[x] = String.valueOf(nums[x]);
    }

    Comparator<String> comp = new Comparator<String>(){
      @Override
      public int compare(String str1, String str2){
        String s1 = str1 + str2;
        String s2 = str2 + str1;//不能只对比两个数 e.g. 3 30 -> 330 > 303
        return s2.compareTo(s1); // reverse order here, so we can do append() later
      }
    };

    Arrays.sort(s, comp);

    if(s[0].equals("0"))return "0";
    StringBuilder sb = new StringBuilder();
    for(int x = 0; x < nums.length; x++){
      sb.append(s[x]);
    }
    return sb.toString();
  }
}
