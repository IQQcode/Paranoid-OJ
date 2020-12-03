package dec01;

import java.util.Scanner;

/**
 * @Author: iqqcode
 * @Date: 2020-12-03 10:31
 * @Description:求任意个数字的最小公倍数（LCM）和最大公约数（GCD）
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] ss = str.split(" ");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.valueOf(ss[i]);
        }
        int gcd = nums[0], lcm = nums[0];
        //两两求出多个数的最大公约数
        for (int i = 0; i < nums.length; i++) {
            gcd = GCD(gcd, nums[i]);
        }
        System.out.println(nums.length + "个数的最大公约数为: " + gcd);
        for (int i = 0; i < nums.length; i++) {
            lcm = LCM(lcm, nums[i]);
        }
        System.out.println(nums.length + "个数的最小公倍数为: " + lcm);
    }

    // 求两数的最小公倍数
    public static int LCM(int a, int b) {
        return a * b / (GCD(a, b));
    }

    // 求两数的最大公约数
    public static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }
}
