package list;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JavaListCopy {
    public static void main(String args[]) throws IOException, CloneNotSupportedException, ClassNotFoundException {
        List<Person> list1 = new ArrayList<Person>();

        list1.add(new Person("aaa"));
        list1.add(new Person("bbb"));
        // 第一种方法：通过构造函数来实现，它里面调用了Arrays.copyOf(),copyOf又调用了System.arraycopy
        List<Person> list2 = new ArrayList<Person>(list1);
        list2.get(0).setName("ccc");

        System.out.println("list1 ==>"+list1);
        System.out.println("list2 ==>"+list2);
        /** 此时list1 和list2 输出相同，说明是引用*/
        // 第二种方法：addAll方法，它调用了System.arraycopy
        // System.arraycopy：源数据-->目的数据
        // Arrays.copyOf():源数据及长度，数据类型，它里面调用了System.arraycopy
        List<Person> list3 = new ArrayList<Person>();
        list3.addAll(list1);
        list3.get(0).setName("ddd");

        System.out.println("list1 ==>"+list1);
        System.out.println("list3 ==>"+list3);
        /** 此时list1 和list3 输出相同，说明是引用*/

        // 第三种方法：实现clone来实现
//        List<Person> list4 = new ArrayList<Person>();
//        for(int i = 0; i< list1.size();i++){
//            list4.add(list1.get(i).clone());
//        }
//        list4.get(0).setName("eee");
//        System.out.println("list1 ==>"+list1);
//        System.out.println("list4 ==>"+list4);
        /** 此处clone了，但要注意实现了cloneable接口只能对原始类型和String进行clone，如果是引用类型，则要进行深clone，复制内容或者对象再次clone*/

        // 第四种方法：通过序列化来实现
//        List<Person> list5 = null;
//        OutputStream bo = new ByteArrayOutputStream();
//        ObjectOutputStream oo = new ObjectOutputStream(bo);
//        oo.writeObject(list1);
//
//        InputStream bi = new ByteArrayInputStream(((ByteArrayOutputStream) bo).toByteArray());
//        ObjectInputStream oi = new ObjectInputStream(bi);
//        list5 = (List<Person>) oi.readObject();
//        list5.get(0).setName("ggg");
//        System.out.println("list1 ==>"+list1);
//        System.out.println("list5 ==>"+list5);
        /** 通过这种方法也能实现深拷贝*/

        // 第五种方法： Collection.copy，它的实现过程是通过遍历然后set进入
        List<Person> list6 = new ArrayList<Person>(Arrays.asList(new Person[list1.size()]));

        Collections.copy(list6, list1);
        list6.get(0).setName("hhh");
        System.out.println("list1 ==>"+list1);
        System.out.println("list6 ==>"+list6);
        /** list1 和list6 输出结果是相同的*/
    }
}
