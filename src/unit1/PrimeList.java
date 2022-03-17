package unit1;

//素数线性表（升序），使用单链表存储，要求尾插入的时间复杂度是O(1)
public class PrimeList {
    private final int range;                           //素数范围上限
    private final SinglyList<Integer> list;            //单链表，存储素数表，循环双链表也可

    public PrimeList(int range)                  //构造方法，存储2～range中所有素数
    {
        if (range <= 1) throw new IllegalArgumentException("range=" + range);//无效参数异常
        this.range = range;
        this.list = new SinglyList<>();   //构造空单链表
        this.list.insert(2);                     //添加已知的最小素数
        Node<Integer> rear = this.list.head.next;  //尾指针
        for (int key = 3; key <= range; key += 2)     //测试奇数，不需测试其他偶数
        {
            if (this.isPrime(key))                //若key是素数，则尾插入，O(1)
            {
                rear.next = new Node<>(key, null);
                rear = rear.next;
            }
//            System.out.println("素数表："+this.list.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(new PrimeList(100));
    }

    public boolean isPrime(int key)              //判断key是否是素数，遍历this.list单链表
    {
        if (key <= 1) throw new IllegalArgumentException("key=" + key);//无效参数异常
//        System.out.print("测试"+key+"，");
        int sqrt = (int) Math.sqrt(key);          //Math.sqrt(key)返回key的平方根值，再将double强制转换成int，小数部分截尾
        //用list中的已知素数测试key，遍历部分list，测试范围到sqrt(key)
        for (Node<Integer> p = list.head.next; p != null && p.data <= sqrt; p = p.next) {
//            System.out.print("%"+p.data+"？");
            if (key % p.data == 0) {
//                System.out.println("false");
                return false;
            }
        }
//        System.out.println("true");
        return true;
    }

    public String toString()                     //返回所有元素的描述字符串
    {
        return "2～" + range + "素数表：" + this.list.toString() + "，" + this.list.size() + "个元素";
    }
}