public class ProductOfTheLastKNumbers {
  List<Integer> l;

  public ProductOfNumbers() {
    l = new ArrayList<>();
    l.add(1);
  }

  public void add(int a) {
    if (a > 0)
      l.add(l.get(l.size() - 1) * a);
    else {//如果是0 那前面的只会得到0 所以清空list重新记就好
      l = new ArrayList();
      l.add(1);
    }
  }

  public int getProduct(int k) {
    int n = l.size();
    return k < n ? l.get(n - 1) / l.get(n - k - 1)  : 0;//最后的/倒数第k个前一个的就是
  }
}
