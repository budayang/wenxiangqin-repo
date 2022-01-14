package java8;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8Test {

    public static void main(String[] args) {
        Java8Test java8Test = new Java8Test();
        Integer value1 = null;
        Integer value2 = new Integer(10);
        Optional<Integer> value11 = Optional.ofNullable(value1);
        Optional<Integer> value21 = Optional.of(value2);
        System.out.println(sum(value11, value21));
    }

    public static Integer sum(Optional<Integer> p1, Optional<Integer> p2) {
        System.out.println("第一个参数值存在：" + p1.isPresent());
        System.out.println("第二个参数值存在：" + p2.isPresent());
        Integer value1 = p1.orElse(new Integer(0));
        Integer value2 = p2.get();
        return value1 + value2;
    }

    @Test
    public void test() {
        System.out.println("lalalaalal");
    }

    @Test
    public void testList() {
        List<String> stringList = new ArrayList<>();
        stringList.add("helloworld");
        stringList.add("hello");
        if (CollectionUtils.isEmpty(stringList)) {
            System.out.println("stringList is empty");
        }
        stringList = stringList.stream().filter(s -> s.equals("helloworld")).collect(Collectors.toList());
        if (stringList.size() > 1) {
            System.out.println("helloworld > 1");
        } else {
            System.out.println("helloworld <= 1");
        }
    }

    @Test
    public void testList1() {
        List<Integer> number = Arrays.asList(1, 2, 2, 3, 4, 5, 4);
//        number.stream().filter(i -> i % 2 == 0).distinct().forEach(Java8Test::print);
        number.stream().filter(i -> i > 2).skip(2).forEach(System.out::println);
        number.stream().filter(i -> i > 2).forEach(System.out::println);
    }

    public static void  print(Integer number) {
        System.out.println(number);
    }

    @Test
    public void testMap() {
        List<String> strings = Arrays.asList("java 8", "lambdas", "in", "action");
        List<Integer> integerList = strings.stream().map(String::length).collect(Collectors.toList());
        integerList.forEach(System.out::println);
    }

    @Test
    public void testMap1() {
        List<String> strings = Arrays.asList("java 8", "lambdas", "in", "action");
        List<String[]> collect = strings.stream().map(s -> s.split("")).distinct().collect(Collectors.toList());
        collect.forEach(strings1 -> {
            System.out.println(strings);
        });
    }

    @Test
    public void testMap2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream().map(n -> n * n).collect(Collectors.toList());
        squares.forEach(System.out::println);
    }

    @Test
    public void testFlatMap() {
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(4, 5);

        List<int[]> paris = number1
                                    .stream()
                                    .flatMap(i -> number2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j}))
                                    .collect(Collectors.toList());
        paris.stream().forEach(
               Java8Test::soutInt
        );
    }

    public static void soutInt(int[] numArr) {
        for (int i : numArr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    @Test
    public void testFind() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional<Integer> optional = numbers.stream().map(n -> n * n).filter(n -> n % 3 == 0).findFirst();
        Integer integer = optional.get();
        System.out.println(integer);
    }
}
