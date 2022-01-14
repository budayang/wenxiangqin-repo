package java8;

import javafx.util.Pair;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import static java.util.Comparator.comparing;

public class Test1 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
//        test1.t2();
//        test1.t3();
//        test1.t4();
//        test1.t5();
//        test1.t6();
//        test1.t7();
//        test1.t8();
//        test1.t9();
//        test1.t10();
//        test1.t11();
//        test1.t12();
        test1.t13();
    }

    public void t1() {
        ArrayList<Apple> inventory = new ArrayList<>();
        Collections.sort(inventory, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.sort(comparing(Apple::getWeight));
    }

    public void t2() {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple("green", 110));
        apples.add(new Apple("green", 160));
        apples.add(new Apple("red", 130));
        apples.add(new Apple("yellow", 170));
        List<Apple> apples1 = Apple.filterApples(apples, Apple::isGreenApple);
        List<Apple> apples2 = Apple.filterApples(apples, Apple::isHeavyApple);
        apples1.forEach(System.out::println);
        System.out.println("---------------------");
        apples2.forEach(System.out::println);
        System.out.println("---------lambda---------");
        List<Apple> apples3 = Apple.filterApples(apples, (Apple a) -> "green".equals(a.getColor()));
        List<Apple> apples4 = Apple.filterApples(apples, (Apple a) -> 150 < a.getWeight());
        apples3.forEach(System.out::println);
        System.out.println("---------------------");
        apples4.forEach(System.out::println);

        apples.stream().filter((Apple a) -> a.getWeight() > 1);
    }

    public void t3() {
        Optional<Apple> empty = Optional.of(new Apple("green", 200));
        System.out.println(empty.equals(new Apple("yellow", 190)));
    }

    public void t4() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = dateFormat.format(date);
        System.out.println(s);
    }

    public void t5() {
        int nano = Instant.now().getNano();
        System.out.println(nano);
    }

    public void t6() {
        Calendar instance = Calendar.getInstance();
        instance.set(2020, 1, 9);
        instance.add(Calendar.DATE, LocalDate.of(2020, 1, 9).lengthOfYear());
        System.out.println(instance.getTime());
    }

    public void t7() {
        HashMap<String, Object> map = new HashMap<>(16);
        if (map.isEmpty()) {
            System.out.println("no element in this map");
        }
    }

    public void t8() {
        ArrayList<Pair<String, Double>> arrayList = new ArrayList<>(3);
        arrayList.add(new Pair<>("vesion", 12.10));
        arrayList.add(new Pair<>("vesion", 12.20));
        arrayList.add(new Pair<>("vesion", 6.28));
        arrayList.stream().collect(Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
    }

    public void t9() {
        ArrayList<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");
        String[] strings = list.toArray(new String[0]);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public void t10() {
        String[] arrays = {"hello", "alibaba", "Love"};
        List<String> list = Arrays.asList(arrays);
        for (String s : list) {
            System.out.println(s);
        }
        arrays[1] = "zhifubao";
        for (String s : list) {
            System.out.println(s);
        }
    }

    public void t11() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("1".equals(next)) {
                iterator.remove();
            }
        }
        for (String s : arrayList) {
            System.out.println(s);
        }
    }

    public void t12() {
        HashMap<String, String> hashMap = new HashMap<>(16);
        hashMap.put("zhangsan", "1");
        hashMap.put("lisi", "2");
        hashMap.put("wangwu", "3");
        hashMap.put("zhaoliu", "4");
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        hashMap.forEach((key, value) -> System.out.println(key));
    }

    public void t13() {
        List<String> stringList = Lists.newArrayList();
        stringList.add("zhangsan");
        stringList.add("lisi");
        stringList.add("wangwu");
        List<String> stringList1 = stringList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        stringList1.forEach(System.out::println);
    }

}
