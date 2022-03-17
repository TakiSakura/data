package unit1;

//注意：泛型<T>的实际参数只能是类，不能是基本类型char、int等
public class Josephus1 {
    // n个人，n>0；从start开始计数，0≤start<n；每次数到distance个人出环，0<distance<n
    public Josephus1(int n, int start, int distance) {
        if (start < 0 || start >= n || distance <= 0 || distance >= n)// 若参数无效，则抛出无效参数异常
            throw new IllegalArgumentException("n=" + n + "，start=" + start + "，distance=" + distance);
        System.out.print("Josephus(" + n + "," + start + "," + distance + ")，");
        // 创建顺序表实例，元素类型是字符串，构造方法参数指定顺序表容量，省略时取默认值
        var list = new SeqList<>(n);
        for (int i = 0; i < n; i++)                   // 顺序表尾插入n个元素
            list.insert((char) ('A' + i) + "");       // 顺序表尾插入，O(1)
        System.out.println(list);     // 输出顺序表，O(n)
//        System.out.println("，"+list.toPreviousString());  // 反序输出

        while (n > 1) {                       // 循环，每次计算删除一个
            start = (start + distance - 1) % n;      // 按环形方式计数
            // 输出删除的start位置对象和顺序表中剩余元素，两者O(n)
            System.out.println("删除" + list.remove(start) + "，" + list);
            n--;
//            System.out.println("，start="+start+"，n="+n);
        }
        System.out.println("被赦免者是" + list.get(0));// get(0)获得元素，O(1)
    }

    public static void main(String[] args) {
        //图2.3
//        String values[]={"A","B","C","D","E"};
//        Unit1.SeqList<String> lista = new Unit1.SeqList<String>(values);

        //【例2.1】求解Josephus环问题。
        new Josephus1(5, 1, 3);
    }
}