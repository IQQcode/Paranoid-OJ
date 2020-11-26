
public class SqrtRes {
    public static float sqr(float x) {
        float max = x;
        float min = 0;
        float mid = (min + max) / 2;
        while (true) {
            if (Math.abs(x - mid * mid) < 0.002) return mid;

            if (mid * mid > x) {
                max = mid;
            } else if (mid * mid < x) {
                min = mid;
            }

            mid = (min + max) / 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(sqr(2));
    }

}
