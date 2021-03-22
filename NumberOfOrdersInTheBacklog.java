public class NumberOfOrdersInTheBacklog {
  public int getNumberOfBacklogOrders(int[][] orders) {
    PriorityQueue<Integer> sell = new PriorityQueue<>();
    PriorityQueue<Integer> buy = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
    HashMap<Integer, Integer> s = new HashMap<>();
    HashMap<Integer, Integer> b = new HashMap<>();
    for(int x = 0; x < orders.length; x++){
      if(orders[x][2] == 0){//buy
        while(!sell.isEmpty() && sell.peek() <= orders[x][0] && orders[x][1] > 0){
          if(s.get(sell.peek()) > orders[x][1]){
            s.put(sell.peek(), s.get(sell.peek()) - orders[x][1]);
            orders[x][1] = 0;
          }
          else{
            orders[x][1] -= s.get(sell.peek());
            s.put(sell.peek(), 0);
            sell.poll();
          }
        }
        if(orders[x][1] > 0){
          buy.add(orders[x][0]);
          b.put(orders[x][0], b.getOrDefault(orders[x][0], 0)+ orders[x][1]);
        }
      }else{//sell
        while(!buy.isEmpty() && buy.peek() >= orders[x][0] && orders[x][1] > 0){
          if(b.get(buy.peek()) > orders[x][1]){
            b.put(buy.peek(), b.get(buy.peek()) - orders[x][1]);
            orders[x][1] = 0;
          }
          else{
            orders[x][1] -= b.get(buy.peek());
            b.put(buy.peek(), 0);
            buy.poll();
          }
        }
        if(orders[x][1] > 0){
          sell.add(orders[x][0]);
          s.put(orders[x][0], s.getOrDefault(orders[x][0], 0) + orders[x][1]);
        }
      }
    }
    int res = 0;
    for(Integer i : b.keySet()){
      res += b.get(i);
      res = res % ((int)Math.pow(10, 9) +7);
    }
    for(Integer i : s.keySet()){
      res += s.get(i);
      res = res % ((int)Math.pow(10, 9) +7);
    }
    return res % ((int)Math.pow(10, 9) +7);
  }
}
