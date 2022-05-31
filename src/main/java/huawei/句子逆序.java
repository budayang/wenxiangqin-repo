package huawei;

import java.util.Scanner;

public class 句子逆序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] strs = str.split("\\s+");

        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
