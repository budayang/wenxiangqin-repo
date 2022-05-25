package huawei;

import java.util.Scanner;

public class 计算某字符出现次数 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine().toLowerCase();

        String s = sc.nextLine().toLowerCase();
        System.out.println(str.length() - str.replaceAll(s, "").length());


    }
}
