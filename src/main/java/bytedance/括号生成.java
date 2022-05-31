package bytedance;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {

    public static void main(String[] args) {
        List<String> list = generateParenthesis(4);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);
        return res;
    }

    public static void generate(List<String> res, String ans, int count1, int count2, int n) {
        if (count1 > n || count2 > n) {
            return;
        }

        if (count1 == n && count2 == n) {
            res.add(ans);
        }

        if (count1 >= count2) {
            String s = new String(ans);
            generate(res, s + "(", count1+1, count2, n);
            generate(res, s + ")", count1, count2+1, n);
        }
    }
}
