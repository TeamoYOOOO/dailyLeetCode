public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    //--------hashset O(n)time O(n) space------
    // HashSet<ListNode> hs = new HashSet<>();
    // ListNode curr = head;
    // while(curr != null){
    //     if(hs.contains(curr)) return true;
    //     hs.add(curr);
    //     curr = curr.next;
    // }
    // return false;

    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){//0 1 2 个node都没问题 corner case
      fast = fast.next.next;
      slow = slow.next;
      if(fast == slow) return true;//后写
    }
    return false;
  }
}
