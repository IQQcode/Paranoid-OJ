package iqqcode.top01;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-09-29 15:09
 * @Description:判断IP地址是否合法 【A-B-C-广播地址等都要考虑】
 * 1. 输入的IP是否为空
 * 2. 长度是否在[7, 15]位之间(x.x.x.x -- xxx.xxx.xxx.xxx)
 * 3.首尾是否为 '.'
 * 4. 通过转义("\\.")后,切出来放入数组的每一部分ss[i]长度是否为4
 * 5. 每个元素是否都是数字字符(前导0不合法)
 * 6. 用Integer.parseInt(a[i])转换成数字后判断第一个元素是否为0（0.xx.xx.xx不能成立）
 * 7. (1~255).(0~255).(0~255).(0~255)
 * 【广播地址考虑】第一段不能是0开头，可以全是255 (组播 多播：224.0.0.0–239.255.255.255)
 */
public class _01_IPJudge {
    public static boolean isIP(String s) {
        // 1.检查ip是否为空, 检查ip长度，最短为：x.x.x.x(7位)，最长为：xxx.xxx.xxx.xxx(15位)
        if (s == null || s.length() < 7 || s.length() > 15) {
            return false;
        }
        //2.首尾字符判断是否为.（.x.x.x或x.x.x.x.）
        if (s.charAt(0) == '.' || s.charAt(s.length() - 1) == '.') {
            return false;
        }
        //3. 按"."分割字符串，并判断分割出来的个数，如果不是4个，则是非法IP
        String[] ss = s.split("\\.");
        if (ss.length != 4) return false;
        //4. 对分割得到的每个字符串的每个字符进行逐一判断，如果不是数字0-9，则判定为非法IP
        for (int i = 0; i < ss.length; i++) {
            // 前导0 IP不合法, 如: 01.002.03.004
            if (ss[i].length() > 1 && ss[i].charAt(0) == '0') {
                return false;
            }
            for (int j = 0; j < ss[i].length(); j++) {
                if (ss[i].charAt(j) < '0' || ss[i].charAt(j) > '9') {
                    return false;
                }
            }
        }

        //5.对拆分的每一个字符串进行转换成数字，并判断是否在 0~255之间
        for (int i = 0; i < ss.length; i++) {
            int temp = Integer.parseInt(ss[i]);
            //用Integer.parseInt(a[i])转换成数字后判断第一个元素是否为0（0.xx.xx.xx不能成立）
            // 第一组数范围为[1-255]
            if (i == 0) {
                if (temp < 1 || temp > 255) {
                    return false;
                }
            }
            //判断后三位元素是否在 0-255之间
            if (temp < 0 || temp > 255) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print("请输入IP地址: ");
        Scanner in = new Scanner(System.in);
        String ip = "";
        while (in.hasNext()) {
            ip = in.next();
            if (isIP(ip)) {
                System.out.println("IP合法");
            } else {
                System.err.println("IP非法!");
            }
        }
    }
}
