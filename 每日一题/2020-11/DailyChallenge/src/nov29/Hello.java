package nov29;

/**
 * @Author: iqqcode
 * @Date: 2020-11-30 20:01
 * @Description:
 */
class ClassTest {
    //静态块
    static {
        System.out.println("static blocking...");
    }
}

public class Hello {
    public static void main(String[] args){
        System.out.println("hello word: " + ClassTest.class);
    }
}
