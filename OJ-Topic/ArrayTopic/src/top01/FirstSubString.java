package top01; /**
 * @Author: iqqcode
 * @Date: 2020-10-01 15:03
 * @Description:子字符串第一次出现的位置
 */

import java.util.*;

public class FirstSubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String sub = in.nextLine();
        //indexOf()
        System.out.println(indexOfStr_I(str, sub));
        //转为字符数组比较
        System.out.println(findSubString_II(str, sub));
        // 滑动窗口
        System.out.println(slideToSubString_III(str, sub));
    }

    public static int indexOfStr_I(String str, String sub) {
        return str.indexOf(sub);
    }

    public static int findSubString_II(String str1, String str2) {
        int offset = 0;
        String substr = null;

        if ((str1 == null) || (str2 == null) || (str1.length() < str2.length())) {
            return -1;
        } else {
            while (offset <= (str1.length() - str2.length())) {
                //String.copyValueOf(要复制的字符数组, 开始索引, 复制长度)
                substr = String.copyValueOf(str1.toCharArray(), offset, str2.length());
                if (substr.equals(str2)) {
                    return offset;
                }
                offset++;
            }
            return -1;
        }
    }


    public static int slideToSubString_III(String str, String sub) {
        int i = 0, j = 0;
        int index = 0;
        while (i < str.length() && j < sub.length()) {
            if (str.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == sub.length()) {
                return i - j;
            }
        }
        return 0;
    }
}
