import java.util.ArrayList;

class AAA{
    int o=40;
    int p=50;
    static void change(AAA x){
        int temp=x.o;
        x.o=x.p;
        x.p=temp;
    }
    public static void main(String[] args) {
        AAA a1=new AAA();
        System.out.println(a1.o+" "+a1.p);
        change(a1);
        System.out.println(a1.o+" "+a1.p);
    }}