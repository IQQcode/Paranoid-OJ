package dec01;

import java.util.Scanner;

/**
 * @Author: iqqcode
 * @Date: 2020-12-02 19:37
 * @Description:最大公因数和最小公倍数
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        // 辗转相除
        System.out.println(gcfI(a, b));
        System.out.println(gcfI_rec(a, b));
        System.out.println(lcmI(a, b));

        // 穷举法
        System.out.println(gcfII(a, b));
        System.out.println(lcmII(a, b));

        // 更相减损术
        System.out.println(gcfIII(a, b));
        System.out.println(lcmIII(a, b));

        System.out.println("---------- 4 % 8" + 4 % 8);
    }

    /**
     * [1-辗转相除法] 求最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcfI(int a, int b) {
        int temp = 0;
        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // 辗转相除-递归
    public static int gcfI_rec(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcfI_rec(b, a % b);
        }
    }


    /**
     * [1-辗转相除法] 求最小公倍数
     *
     * @param a
     * @param b
     * @return
     */
    public static int lcmI(int a, int b) {
        // a*b/最大公约数
        return a * b / gcfI(a, b);
    }


    /**
     * [2-穷举法] 求最大公因数
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcfII(int a, int b) {
        //求出两数中的较小值
        int ans = Math.min(a, b);
        while (ans > 0) {
            if (a % ans == 0 && b % ans == 0) {
                break;
            }
            ans--;
        }
        return ans;
    }

    // [2-穷举法] 求最小公倍数
    public static int lcmII(int a, int b) {
        int num1, num2, ans;
        //两数较大值
        ans = num1 = a > b ? a : b;
        //两数较小值
        num2 = a > b ? b : a;
        while (true) {
            if (num1 % num2 == 0) {
                break;
            }
            num1 += ans;
        }
        return num1;
    }


    /**
     * [3-更相减损术] 求最大公因数
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcfIII(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    // [递归求解]
    public static int gcfIII_res(int a, int b) {
        //保证 a > b
        if (a < b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        if (a - b == b) {
            return b;
        } else {
            return gcfIII_res(a - b, b);
        }
    }

    // [3-更相减损术] 求最小公倍数
    public static int lcmIII(int a, int b) {
        return a * b / gcfIII(a, b);
    }
}
