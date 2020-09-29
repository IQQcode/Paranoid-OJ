package iqqcode.top01;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: iqqcode
 * @Date: 2020-09-29 15:32
 * @Description:判断IP地址是否合法--正则表达式
 */
public class _01_IPJudge_expression {
    public static boolean isIpLegal(String ipStr) {
        //ip地址范围：(1~255).(0~255).(0~255).(0~255)
        String ipRegEx = "^([1-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))(\\.([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))){3}$";
        Pattern pattern = Pattern.compile(ipRegEx);
        Matcher matcher = pattern.matcher(ipStr);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = "";
        while (in.hasNext()) {
            ip = in.next();
            if (isIpLegal(ip)) {
                System.out.println("IP合法");
            } else {
                System.err.println("IP非法!");
            }
        }
    }
}
