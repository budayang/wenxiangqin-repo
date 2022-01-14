package p1;

public class FinalTest {

    public static void main(String[] args) {
        t1();
    }

    public static void t1() {
        //1、修饰基本类型，变量不能被再次赋值
        final int a = 4;
        //2、修饰引用类型变量，变量不能被再次赋值，但是无法改变所指向的对象的值的改变
        final StringBuffer stringBuffer = new StringBuffer("java");
        stringBuffer.append("Script");
        System.out.println(stringBuffer);

        System.out.println(3%3);

        String s = "Hello";
        switch (s) {
            case "Hello":
            case "hello":
                System.out.println(111111);
        }
    }
}
