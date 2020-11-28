package nov26;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-11-26 21:28
 * @Description:
 */
public class BottomChange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            if(n == 0) return;
            int count = 0;
            while(n >= 3) {
                //加上手里能够换取瓶子的数量
                count += n / 3;
                n = n / 3 + n % 3;
            }
            if(n == 2) count++;
            System.out.println(count);
        }
    }
}
