package dec01;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-12-02 17:15
 * @Description:找规律
 * @Link: https://www.nowcoder.com/questionTerminal/1183548cd48446b38da501e58d5944eb
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int row = in.nextInt();
            int col = in.nextInt();
            int ans = 0, count = 0;
            // row & col 均为4的倍数
            if (row % 4 == 0 || col % 4 == 0) {
                ans = row * col;
                count = ans / 2;
            } else if (row % 2 == 0 && col % 2 == 0) {
                // row & col 均为2的倍数
                // 4 * 8 和 6 * 8放置的数目是相同的
                ans = row * col / 4;
                count = (ans + 1) / 2;
                count *= 4;
            } else if (row % 2 == 0 || col % 2 == 0) {
                // row || col 为2的倍数 (以 6 * 9 为例 ==> 6 * 10)
                ans = row * col / 2;
                // count + 1凑成偶数再除2
                count = (ans + 1) / 4;
                count *= 4;
            } else {
                // row col 均为奇数
                ans = (row * 2) *  (col * 2) / 4;
                count = (ans + 1) / 2;
            }
            System.out.println(count);
        }
    }
}
