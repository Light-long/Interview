package com.tx.javase;

/**
 * 类初始化过程<clinit>
 *  1.父类初始化（静态变量，静态代码块）：5，1
 *  2.子类初始化（静态变量，静态代码块）：10,6
 * 实例初始化过程<init>
 *  3.super(),即父类对应的init()：9,3,2
 *      父类初始化，即super(),属性(涉及到重写所以是9)，非静态代码块，无参构造
 *      创建的是子类对象，调用子类重写的test方法
 *  4.i= test() ：9
 *  5.子类的非静态代码块：8
 *  6.子类的无参构造 ：7
 */

/**
 * 类初始化
 * 1.子类初始化需要先初始化父类
 * 2.类变量显示赋值代码和静态代码块从上到下顺序执行
 * 3.类初始化一次
 */

/**
 * 实例初始化
 * 1.几个构造器就有几个init方法
 * 2.init方法由 非静态实例变量显示赋值和非静态代码块，对应构造器代码组成
 * 3.顺序：非静态实例变量显示赋值代码和非静态代码块从上到下顺序执行，构造器最后执行
 * 4.init方法的首行是super()
 */

/**
 * final方法，静态方法，private等子类中不可见的方法 不能被重写Override
 */
public class Son extends Father{
    private int i = test();
    private static int j = method();

    static {
        System.out.println("(6)");
    }
    Son() {
        System.out.println("(7)");
    }
    {
        System.out.println("(8)");
    }
    @Override
    public int test() {
        System.out.println("(9)");
        return 1;
    }

    public static int method() {
        System.out.println("(10)");
        return 1;
    }

    public static void main(String[] args) {
        // 5 1 10 6 9 3 2 9 8 7
        Son son1 = new Son();
        System.out.println();
        // 9 3 2 9 8 7
        Son son2 = new Son();
    }
}
