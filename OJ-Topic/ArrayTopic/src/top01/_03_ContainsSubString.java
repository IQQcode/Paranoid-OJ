package top01;

/**
 * @Author: iqqcode
 * @Date: 2020-10-04 11:07
 * @Description:源字符串中是否包含子串
 */
public class _03_ContainsSubString {
    public static void main(String[] args) {
        String str = "www.baidu.com/www.sina.com---www";
        String subStr = "www";

        System.out.println(str.contains(subStr));
    }
}
