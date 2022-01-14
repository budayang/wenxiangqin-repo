/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package java8.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author wenxiangqin
 * @version $Id: MapAndFlatMap.java, v 0.1 2021-12-01 2:30 下午 wenxiangqin Exp $$
 */
public class MapAndFlatMap {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream().map(n -> n * n).collect(Collectors.toList());
        squares.forEach(System.out::println);
    }

    public static void test2() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> paris = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
        for (int[] pari : paris) {

        }
    }
}