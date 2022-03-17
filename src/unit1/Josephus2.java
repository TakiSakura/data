package unit1;

import java.util.ArrayList;

//【例2.3】求解Josephus环问题，使用单链表。
public class Josephus2 {
    //n个人，n>0；从start开始计数，0≤start<n；每次数到distance个人出环，0<distance<n
    public Josephus2(int n, int start, int distance) {
        if (start < 0 || start >= n || distance <= 0 || distance >= n)//若参数无效，则抛出无效参数异常
            throw new IllegalArgumentException("n=" + n + "，start=" + start + "，distance=" + distance);

        SinglyList<String> list = new SinglyList<>();//构造空单链表
        for (int i = n - 1; i >= 0; i--)
            list.insert(0, (char) ('A' + i) + "");    //单链表头插入，O(1)
        System.out.println("Josephus(" + n + "," + start + "," + distance + ")，" + list); //输出单链表，O(n)

        // 求解Josephus环，循环计数。与顺序表不同，不能计算下标
        Node<String> front = list.head;
        for (int i = 0; front != null && i < start; i++)//计数，front指向第start-1个结点
            front = front.next;

        while (n > 1)                               //循环，每次计算删除一个元素
        {
            for (int i = 1; i < distance; i++)        //计数，寻找删除结点。少数一个，front指向待删除结点的前驱
            {
                assert front != null;
                front = front.next;
                if (front == null)                  //实现循环计数。该条件不能写到for语句中，因为会停止循环
                    front = list.head.next;
            }
            assert front != null;
            if (front.next == null)                 //若front指向最后一个结点，则删除第0个结点
                front = list.head;
            System.out.print("删除" + front.next.data + "，");
            front.next = front.next.next;        //删除front的后继结点，包括头删除、中间/尾删除
            n--;
            System.out.println(list);
        }
        System.out.println("被赦免者是" + list.get(0));//get(0)获得元素，O(1)
    }

    public static void main(String[] args) {
        new Josephus2(5, 4, 3);
        ArrayList<String> list = new ArrayList<>();
    }

}