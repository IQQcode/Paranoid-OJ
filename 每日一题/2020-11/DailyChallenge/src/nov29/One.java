package nov29;

/**
 * @Author: iqqcode
 * @Date: 2020-11-30 19:22
 * @Description:
 */

class MyClass {
    public MyClass() {
        System.out.println("父类构造方法");
    }

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类非静态代码块");
    }

    public static void method() {
        System.out.println("父类普通方法执行");
    }
}

public class One extends MyClass{
    public One() {
        System.out.println("子类构造方法");
    }

    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类非静态代码块");
    }
    public static void method() {
        System.out.println("子类普通方法执行");
    }


    public static void main(String[] args) {
        System.out.println("子类main方法执行");

        MyClass once = new One();
        once.method();

        System.out.println("------------");

        MyClass twice = new One();
        twice.method();
    }
}

/*
////// 分割线
// 在子类中执行main方法
父类静态代码块
子类静态代码块
main
父类非静态代码块
父类构造方法
子类非静态代码块
子类构造方法
// 如果再new One(); 执行顺序姿势main下面的再执行一遍，静态部分只是执行一次

在父类中执行main()方法 执行顺序如下。这也说明了静态代码块只执行一次
父类静态代码块
main
子类静态代码块
父类非静态代码块
父类构造方法
子类非静态代码块
子类构造方法
   */
