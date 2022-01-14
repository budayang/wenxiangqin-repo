package java8;

import jdk.nashorn.internal.ir.CallNode;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMapTest {

    public List<Apple> initApple() {
        List<Apple> appleList = new ArrayList<>();
        Apple a1 = new Apple("red", 100);
        Apple a2 = new Apple("green", 110);
        Apple a3 = new Apple("red and green", 120);
        appleList.add(a1);
        appleList.add(a2);
        appleList.add(a3);
        return appleList;
    }


    @Test
    public void t1() {
        List<Apple> appleList = initApple();
        List<String> colors = appleList.stream().map(Apple::getColor).collect(Collectors.toList());
        colors.stream().forEach(color -> System.out.println(color));
    }

    @Test public void t2() {
        List<Apple> appleList = initApple();
        List<Integer> appLengths = appleList.stream().map(Apple::getColor).map(String::length).collect(Collectors.toList());
        appLengths.stream().forEach(leg -> System.out.println(leg));
    }

    @Test public void t3() {
        String[] words = {"Hello", "World"};
        List<String> strings = Arrays.asList(words);
        List<String> collect = strings.stream().map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        collect.stream().forEach(s -> System.out.println(s));
    }

    @Test public void t4() {
        Integer[] integers = {1, 2, 3, 4, 5};
        List<Integer> collect = Arrays.stream(integers).map(i -> i * i).collect(Collectors.toList());
        collect.stream().forEach(c -> System.out.println(c));
    }

    @Test public void t5() {
        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(3, 4);
        List<int[]> ints = num1.stream().flatMap(i -> num2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());

    }
}
