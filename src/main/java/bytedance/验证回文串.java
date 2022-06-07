package bytedance;

public class 验证回文串 {

    public boolean isPalindrome(String s) {
        if(s == null) {
            return true;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
