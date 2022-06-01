package bytedance;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix[0].length == 0 || matrix.length == 0) {
            return list;
        }
        // 左边
        int l = 0;
        // 右边
        int r = matrix[0].length - 1;
        // 上边
        int u = 0;
        // 下边
        int d = matrix.length - 1;

        while (l <= r && u <= d) {
            for (int i = l; i <= r; i++) {
                list.add(matrix[u][i]);
            }
            u++;
            for (int i = u; i <= d; i++) {
                list.add(matrix[i][r]);
            }
            r--;
            for (int i = r; i >= l && u <= d; i--) {
                list.add(matrix[d][i]);
            }
            d--;
            for (int i = d; i >= u && l <= r; i--) {
                list.add(matrix[i][l]);
            }
            l++;
        }

        return list;
    }
}
