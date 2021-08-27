public class InsertDeleteGetRandomDuplicatesAllowed {
  ArrayList<Integer> lst;
  HashMap<Integer, Set<Integer>> idx;
  Random rand = new Random();

  /** Initialize your data structure here. */
  public RandomizedCollection() {
    lst = new ArrayList<Integer>();
    idx = new HashMap<Integer, Set<Integer>>();
  }

  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  public boolean insert(int val) {
    if (!idx.containsKey(val)) idx.put(val, new LinkedHashSet<Integer>());
    idx.get(val).add(lst.size());//先
    lst.add(val);//后
    return idx.get(val).size() == 1;
  }


  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  public boolean remove(int val) {
    if (!idx.containsKey(val) || idx.get(val).size() == 0) return false;
    int remove_idx = idx.get(val).iterator().next();
    idx.get(val).remove(remove_idx);
    int last = lst.get(lst.size() - 1);
    lst.set(remove_idx, last);//反正只移除最后一个 如果最后一个不是val swap了 没关系 是的话也没关系 换完了等于没换 删的还是val
    idx.get(last).add(remove_idx);
    idx.get(last).remove(lst.size() - 1);

    lst.remove(lst.size() - 1);
    return true;
  }

  /** Get a random element from the collection. */
  public int getRandom() {
    return lst.get(rand.nextInt(lst.size()));
  }
}
