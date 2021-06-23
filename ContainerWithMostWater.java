public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int max = 0;
    int l = 0, r = height.length-1;
    while(l < r){
      int curr = (r-l)*Math.min(height[l], height[r]);
      max = Math.max(curr, max);
      if(height[l] < height[r]){
        l++;
      }else{
        r--;
      }
    }
    return max;
  }
}
