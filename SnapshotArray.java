public class SnapshotArray {
  List<HashMap<Integer, Integer>> list;
  HashMap<Integer, Integer> hm;

  public SnapshotArray(int length) {
    list = new ArrayList<>();
    hm = new HashMap<>();
  }

  public void set(int index, int val) {
    hm.put(index, val);
  }

  public int snap() {
    list.add(new HashMap<>(hm));
    return list.size()-1;
  }

  public int get(int index, int snap_id) {
    if(!list.get(snap_id).containsKey(index)) return 0;//!!!!注意没有set过的都是0
    return list.get(snap_id).get(index);
  }




  //initialize和和snap太慢了 O(n)
//     List<List<Integer>> list;
//     int count;
//     public SnapshotArray(int length) {
//         list = new ArrayList<>();
//         for(int x = 0; x < length; x++){
//             list.add(new ArrayList<>());
//             list.get(x).add(0);
//         }
//         count = 0;
//     }

//     public void set(int index, int val) {
//         int size = list.get(index).size();
//         list.get(index).set(size-1, val);
//         // list.get(index).add(val);注意不能直接add因为不一定每次都snap了 如果没有snap就直接替换当前对应index的list的最后一个数
//         //["SnapshotArray","set","set","set","snap","get","snap"]
//         //[[1],[0,4],[0,16],[0,13],[],[0,0],[]]
//     }

//     public int snap() {
//         for(int x = 0; x < list.size(); x++){
//             list.get(x).add(list.get(x).get(list.get(x).size()-1));
//         }
//         count++;
//         return count-1;
//     }

//     public int get(int index, int snap_id) {
//         return list.get(index).get(snap_id);
//     }
}
