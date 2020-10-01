package top01;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-10-01 20:36
 * @Description:记录子串出现的位置及次数
 */
public class SubStringLocation {
    public static void main(String[] args) {
        String str = "www.baidu.com/www.sina.com---www";
        String subStr = "www";

        checkI(str, subStr);
        checkII(str, subStr);
        checkIII(str, subStr);
    }

    /**
     * 【思路一】:
     * - 使用String类的indexOf方法，每次找到第一次出现的子串后，改变起始寻找位置
     *
     * @param str
     * @param subStr
     */
    public static void checkI(String str, String subStr) {
        int index = 0, count = 0;
        List<Integer> list = new ArrayList<>();
        while (index <= str.length()) {
            index = str.indexOf(subStr, index);
            if (index == -1) {
                break;
            }
            list.add(index);
            index += 1;
            count++;
        }
        System.out.println(list);
        System.out.println(count);
    }

    /**
     * 【思路二】: 无法记录出现位置
     * 使用子串来切割父串，根据结果数组长度获取次数
     * 考虑特殊情况--> 子串在末尾，要给截取结果数组长度加1
     *
     * @param str
     * @param subStr
     */
    public static void checkII(String str, String subStr) {
        int count = 0;
        String[] arr = str.split(subStr);
        int len = arr.length;
        if (str.endsWith(subStr)) {
            //如果子串在末尾
            len++;
        }
        count = len - 1;
        System.out.println(count);
    }

    /**
     * 【思路三】: 无法记录出现位置
     * @param str
     * @param subStr
     */
    public static void checkIII(String str, String subStr) {
        // 定义计数器
        int count = 0;
        // 定义变量，保存indexOf查找后的结构
        int index = 0;
        // 开始循环找,条件，indexOf == -1字符串没有了
        // 先用str.indexOf(key)找索引赋值给index，如果index=-1，则说明有字符串
        while ((index = str.indexOf(subStr)) != -1) {
            count++;
            //获取索引，和字符串长度求和，截取字符串
            str = str.substring(index + subStr.length());
        }
        System.out.println(count);
    }
}
