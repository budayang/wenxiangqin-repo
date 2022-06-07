package bytedance;

public class 反转字符串中的单词III {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String string : str) {
            sb.append(new StringBuilder(string).reverse().toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
