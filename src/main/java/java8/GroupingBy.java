/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author wenxiangqin
 * @version $Id: GroupingBY.java, v 0.1 2021-12-01 2:47 下午 wenxiangqin Exp $$
 */
public class GroupingBy {
    public static void main(String[] args) {
        List<Fruit> fruitList = Arrays.asList(new Fruit("apple", 3), new Fruit("banana", 2), new Fruit("apple", 3), new Fruit("grape", 6), new Fruit("banana", 2));
        Map<String, List<Fruit>> collect = fruitList.stream().collect(Collectors.groupingBy(Fruit::getName));
        collect.forEach((s, fruits) -> System.out.println(s));
    }
}

class Fruit {

    private String name;
    private Double price;

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Getter method for property name.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property name.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property price.
     *
     * @return property value of price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Setter method for property price.
     *
     * @param price value to be assigned to property price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}