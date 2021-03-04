public class LowestCommonAncestorOfaBinaryTree3 {
  public Node lowestCommonAncestor(Node p, Node q) {
    Node pp = p;
    Node pq = q;
    while(pp != pq){
      pp = pp == null? q : pp.parent;
      pq = pq == null? p : pq.parent;
    }
    return pp;
  }
}
