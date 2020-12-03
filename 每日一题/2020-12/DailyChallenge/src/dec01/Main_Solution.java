package dec01;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-12-03 15:59
 * @Description:
 */
public class Main_Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int row = in.nextInt();
            int col = in.nextInt();
            // 二维boolean数组元素默认都为 false
            boolean[][] arr = new boolean[row][col];
            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // false表示可以放到当前位置
                    if (!arr[i][j]) {
                        count++;
                        // 隔2不能放
                        if ((i + 2) < row) arr[i + 2][j] = true;
                        if ((j + 2) < col) arr[i][j + 2] = true;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
