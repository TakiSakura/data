package unit1;

//ע�⣺����<T>��ʵ�ʲ���ֻ�����࣬�����ǻ�������char��int��
public class Josephus1 {
    // n���ˣ�n>0����start��ʼ������0��start<n��ÿ������distance���˳�����0<distance<n
    public Josephus1(int n, int start, int distance) {
        if (start < 0 || start >= n || distance <= 0 || distance >= n)// ��������Ч�����׳���Ч�����쳣
            throw new IllegalArgumentException("n=" + n + "��start=" + start + "��distance=" + distance);
        System.out.print("Josephus(" + n + "," + start + "," + distance + ")��");
        // ����˳���ʵ����Ԫ���������ַ��������췽������ָ��˳���������ʡ��ʱȡĬ��ֵ
        var list = new SeqList<>(n);
        for (int i = 0; i < n; i++)                   // ˳���β����n��Ԫ��
            list.insert((char) ('A' + i) + "");       // ˳���β���룬O(1)
        System.out.println(list);     // ���˳���O(n)
//        System.out.println("��"+list.toPreviousString());  // �������

        while (n > 1) {                       // ѭ����ÿ�μ���ɾ��һ��
            start = (start + distance - 1) % n;      // �����η�ʽ����
            // ���ɾ����startλ�ö����˳�����ʣ��Ԫ�أ�����O(n)
            System.out.println("ɾ��" + list.remove(start) + "��" + list);
            n--;
//            System.out.println("��start="+start+"��n="+n);
        }
        System.out.println("����������" + list.get(0));// get(0)���Ԫ�أ�O(1)
    }

    public static void main(String[] args) {
        //ͼ2.3
//        String values[]={"A","B","C","D","E"};
//        Unit1.SeqList<String> lista = new Unit1.SeqList<String>(values);

        //����2.1�����Josephus�����⡣
        new Josephus1(5, 1, 3);
    }
}