package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 提取不重复整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--) {
            if(!map.containsKey(s.charAt(i))) {
                sb.append(String.valueOf(s.charAt(i)));
                map.put(s.charAt(i), s.charAt(i));
            }
        }
        System.out.print(sb.toString());
    }
}
