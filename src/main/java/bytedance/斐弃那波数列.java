package bytedance;

public class 斐弃那波数列 {

    public int fib(int n) {
        if (n== 0 || n == 1) {
            return n;
        }
        int a = 1, b = 0;
        for (int i = 1; i < n; i++) {
            a = a + b;
            b = a - b;
            a %= 1000000007;
        }
        return a;
    }
}
