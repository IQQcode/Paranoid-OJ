package dec01;

/**
 * @Author: iqqcode
 * @Date: 2020-12-02 17:16
 * @Description:基础题
 */
public class HasStatic {
    private static int x = 100;

    public static void main(String args[]) {
        HasStatic hs1 = new HasStatic();
        hs1.x++; // x = 101
        HasStatic hs2 = new HasStatic();
        hs2.x++; // x = 102
        hs1 = new HasStatic();
        hs1.x++; // x = 103
        HasStatic.x--; // x = 102
        System.out.println("x=" + x);
    }
}

