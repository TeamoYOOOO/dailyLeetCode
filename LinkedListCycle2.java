public class LinkedListCycle2 {
  public ListNode detectCycle(ListNode head) {
    //--------hashset O(n)time O(n) space------
    //     HashSet<ListNode> hs = new HashSet<>();
    //     ListNode curr = head;
    //     while(curr != null){
    //         if(hs.contains(curr)) return curr;
    //         hs.add(curr);
    //         curr = curr.next;
    //     }
    //     return null;

    //---------fast slow pointer--------
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){//0 1 2 个node都没问题 corner case
      fast = fast.next.next;
      slow = slow.next;
      if(fast == slow) break;//后写
    }
    if(fast == null || fast.next == null) return null;
    fast = head;
    while(fast != slow){
      fast = fast.next;
      slow = slow.next;
    }
    return fast;
  }
}
