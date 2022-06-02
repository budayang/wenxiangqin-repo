package bytedance;

public class 比较版本号 {

    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        for (int i = 0; i < Math.max(s1.length, s2.length); i++) {
            int a = (i < s1.length ? Integer.valueOf(s1[i]) : 0);
            int b = (i < s2.length ? Integer.valueOf(s2[i]) : 0);
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = compareVersion("0.1", "1.0");
        System.out.println(i);
    }
}
