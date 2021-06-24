public class ReverseLinkedList2 {
  //one pass
  public ListNode reverseBetween(ListNode head, int left, int right) {
    int i = 0;
    ListNode dh = new ListNode(0);
    ListNode curr = dh;
    curr.next = head;
    ListNode first = null, third = null;
    ListNode secondHead = null, secondEnd = null;
    ListNode prev = null;
    while(curr != null){
      if(i < left){
        first = curr;
        curr = curr.next;
      }
      else if(i > right){
        third = curr;
        curr = curr.next;
        break;
      }
      else{
        if(i == left)
          secondEnd = curr;
        if(i == right)
          secondHead = curr;
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      i++;
    }
    first.next = secondHead;
    secondEnd.next = third;
    return dh.next;
  }

//  public ListNode reverseBetween(ListNode head, int m, int n) {
//    if(head == null) return head;
//    ListNode dh = new ListNode(0);
//    dh.next = head;
//    ListNode tail = dh;
//    ListNode reverseHead = dh;
//    for(int x = 0; x < m-1; x++){
//      tail = tail.next;
//    }
//    for(int x = 0; x < m; x++){
//      reverseHead = reverseHead.next;
//    }
//    ListNode prev = null;
//    ListNode curr = reverseHead;
//    int count = n-m+1;
//    while(count > 0){
//      ListNode next = curr.next;
//      curr.next = prev;
//      prev = curr;
//      curr = next;
//      count--;
//    }
//    tail.next = prev;
//    reverseHead.next = curr;
//    return dh.next;
//  }
}
