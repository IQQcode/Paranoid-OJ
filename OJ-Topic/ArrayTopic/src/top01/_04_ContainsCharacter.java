package top01;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-10-04 11:19
 * @Description: 判断一个字符串里是否包含另一个字符串所有的字符(无序, 包含即可)
 * <p>
 * 比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母。
 * <p>
 * 给出 A = "ABCD" B = "ACD"，返回 true
 * 给出 A = "ABCD" B = "AABC"， 返回 false
 */
public class _04_ContainsCharacter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String subStr = in.next();

        // index
        System.out.println(containsCharacterI(str, subStr));

        // HashMap
        System.out.println(containsCharacterII(str, subStr));
    }

    /**
     * 利用下标偏移量,数组元素统计出现次数(计数排序思想)
     *
     * @param str
     * @param subStr
     * @return
     */
    public static boolean containsCharacterI(String str, String subStr) {
        int[] index = new int[26];
        for (int i = 0; i < str.length(); i++) {
            index[str.charAt(i) - 'A']++;
        }
        for (int i = 0; i < subStr.length(); i++) {
            index[subStr.charAt(i) - 'A']--;
            if (index[subStr.charAt(i) - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * HashMap 统计value次数
     *
     * @param str
     * @param subStr
     * @return
     */
    public static boolean containsCharacterII(String str, String subStr) {
        Map<Character, Integer> map = new HashMap<>();
        // 放入26个大写字母
        for (int i = 0; i < 26; i++) {
            map.put((char) (i + 65), 0);
        }
        // 字符统计
        for (int i = 0; i < str.length(); i++) {
            Character key = str.charAt(i);
            map.put(str.charAt(i), map.get(key) + 1);
        }
        for (int i = 0; i < subStr.length(); i++) {
            Character key = subStr.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) - 1);
            }
            if (map.get(key) < 0) return false;
        }
        return true;
    }
}