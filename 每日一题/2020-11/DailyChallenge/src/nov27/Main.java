package nov27;

/**
 * @Author: iqqcode
 * @Date: 2020-11-28 16:41
 * @Description:
 */
public class Main {
    public static void main(String args[]) throws InterruptedException {
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.print("2");
//            }
//        });
//        t.start();
//
//        t.join();
//        System.out.print("1");

        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a, b);
        System.out.println(a + "." + b);

        int x = 5 >> 2;
        int y =   x >>> 2;
        System.out.println(x + " " + y);
    }

    private static void operate(StringBuffer a, StringBuffer b) {
        a.append(b);
        b = a;
    }
}
