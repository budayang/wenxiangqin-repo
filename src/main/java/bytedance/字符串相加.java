package bytedance;

public class 字符串相加 {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int length1 = num1.length() - 1;
        int length2 = num2.length() - 1;

        while (length1 >= 0 || length2 >= 0 || sum != 0) {
            if (length1 >= 0) {
                sum += num1.charAt(length1--) - '0';
            }
            if (length2 >= 0) {
                sum += num2.charAt(length2--) - '0';
            }
            sb.append(sum % 10);
            sum = sum / 10;
        }

        return sb.reverse().toString();
    }
}
