package nov29;

/**
 * @Author: iqqcode
 * @Date: 2020-11-30 19:20
 * @Description:
 */
public class Main {
    public static void main(String args[]) {
        int num = 10;
        System.out.println(test(num));

        System.out.println(ddfd());
    }

    public static int test(int b) {
        try {
            b += 11;
            return b;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            b += 10;
            return b;
        }
    }

    public static String ddfd(){
        try {
            System.out.println("try");
            return "8888";
        } catch (Exception e){
            System.out.println("catch");
        }finally {
            System.out.println("finally");
            return "9999";
        }
    }

}