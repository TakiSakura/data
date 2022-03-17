package unit1;

//1. 单链表结点类
public class Node<T>                             // 单链表结点类，T指定结点的元素类型
{
    public T data;                               // 数据域，存储数据元素
    public Node<T> next;                         // 地址域，引用后继结点

    public Node(T data, Node<T> next)            // 构造结点，data指定数据元素，next指定后继结点
    {
        this.data = data;                        // T对象引用赋值
        this.next = next;                        // Unit1.Node<T>对象引用赋值
    }

    public Node() {
        this(null, null);
    }

    //没有直接调用。为了调试时用的。
    public String toString()                     // 返回结点数据域的描述字符串
    {
        return this.data.toString();
    }

    //教材没有写，没有直接调用
    public boolean equals(Object obj)            //比较两个结点值是否相等，覆盖Object类的equals(obj)方法
    {
        return obj == this || obj instanceof Node<?> && this.data.equals(((Node<T>) obj).data);
    }
}
/*
1、Java不提供默认拷贝构造方法。
  Node类不需要拷贝构造方法。若拷贝构造方法以下，复制p引用的结点，
    public Unit1.Node(Unit1.Node<T> p)            //拷贝构造方法
    {
        this(p.data, p.next); 
    }
相当于
    public Unit1.Node(Unit1.Node<T> p)
    {
        this.data = p.data;
        this.next = p.next;        //将p的后继结点作为当前结结点的后继结点，逻辑错误
    }
    
2、不能声明如下，比较结点值大小
public class Unit1.Node<T> implements Comparable<Unit1.Node<T>>   //单链表结点类
{
    public int compareTo(Unit1.Node<T> p)                  //比较相等，比较大小
    {
        return this.data.compareTo(p.data);          //编译错，T类没有compareTo()方法
    }
}
排序单链表应该要求比较T对象大小，不能要求比较结点大小。
*/
