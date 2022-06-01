package bytedance;

public class 搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // 行
        int m = 0;
        // 列
        int n = matrix[0].length - 1;
        while(m <= matrix.length -1 && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;
    }
}
