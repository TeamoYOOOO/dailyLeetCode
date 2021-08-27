public class SimplifyPath {
  public String simplifyPath(String path) {
    String[] arr = path.split("/");
    StringBuilder sb = new StringBuilder();
    Stack<String> s = new Stack<>();
    for(int x = 0; x < arr.length; x++){
      if(arr[x].length() == 0 || arr[x].equals(".")) continue;
      if(arr[x].equals("..") ){
        if(!s.isEmpty()) s.pop();
      }else{
        s.push(arr[x]);
      }
    }
    while(!s.isEmpty()){
      sb.insert(0, s.pop());
      sb.insert(0, "/");
    }
    if(sb.length() == 0) return "/";
    return sb.toString();
  }
}
