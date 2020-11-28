package nov28;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-11-28 17:09
 * @Description:完全背包问题
 * @Link: https://www.nowcoder.com/questionTerminal/9aaea0b82623466a8b29a9f1a00b5d35?f=discussion
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] value = new int[n + 1];
        int capacity = 40;
        for (int i = 1; i <= n; i++) {
            value[i] = in.nextInt();
        }
        System.out.println(design(capacity, value, n));
    }

    /**
     * dp[i][j]表示当有i个物品时，凑成体积为j的方法数
     * 对于第i个物品，只有拿和不拿两种选择。所以它的方法数等于 拿 + 不拿 的方法总数
     * dp[i][j] = dp[i-1][j] + dp[i-1][j-value[i]]
     *
     * @param capacity
     * @param value
     * @return
     */
    public static int design(int capacity, int[] value, int n) {
        int[][] dp = new int[n + 1][capacity + 1];
        //初始化第一行，无物品无法装
        // dp[0][k] = 0
        //初始化第一列，capacity = 0不用装
        //当无背包和无物品时都为0， 是一种方法
        for (int k = 1; k <= n; k++) {
            dp[k][0] = 1; // 故初始化为1
        }

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (value[i] > j) {
                    //当前物品的体积大于背包容量时，不拿
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 当前物品体积小于背包capacity,拿
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - value[i]];
                }

            }
        }
        return dp[n][capacity];
    }
}
