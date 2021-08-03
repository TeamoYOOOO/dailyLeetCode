public class TrappingRainWater {
  public int trap(int[] A) {
    //-------2 pointer---------
    // int l=0;
    // int r=A.length-1;
    // int max=0;
    // int leftmax=0;
    // int rightmax=0;
    // while(l<=r){
    //     leftmax=Math.max(leftmax,A[l]);
    //     rightmax=Math.max(rightmax,A[r]);
    //     if(leftmax<rightmax){
    //         max+=(leftmax-A[l]);// leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
    //         l++;
    //     }
    //     else{
    //         max+=(rightmax-A[r]);
    //         r--;
    //     }
    // }
    // return max;

    //-------Stack看答案然后自己写的——------
    int i = 0, max = 0, res = 0;
    Stack<Integer> s = new Stack<Integer>();
    while(i < A.length){
      int curr = A[i];
      while(!s.isEmpty() && A[s.peek()] < curr){
        int pop = s.pop();
        int diff = s.isEmpty()? 0: (Math.min(curr, A[s.peek()]) - A[pop])*(i-s.peek()-1);//是i-s.peek()-1不是i-pop 算整个要加的范围长度
        res += diff;
      }
      s.push(i);
      i++;
    }
    return res;

    //-----------Stack答案----------
    // if (A==null) return 0;
    // Stack<Integer> s = new Stack<Integer>();
    // int i = 0, maxWater = 0, maxBotWater = 0;
    // while (i < A.length){
    //     if (s.isEmpty() || A[i]<=A[s.peek()]){
    //         s.push(i++);
    //     }
    //     else {
    //         int bot = s.pop();
    //         maxBotWater = s.isEmpty()? 0:(Math.min(A[s.peek()],A[i])-A[bot])*(i-s.peek()-1);
    //         maxWater += maxBotWater;
    //     }
    // }
    // return maxWater;
  }
}
