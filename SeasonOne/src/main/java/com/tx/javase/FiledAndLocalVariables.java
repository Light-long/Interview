package com.tx.javase;

/**
 * 就近原则+作用域
 *
 * 局部变量：形参，{}内，代码块中----栈
 * 成员变量：类中方法外
 *      -- 类变量：方法区
 *      -- 成员变量：堆
 *
 * 画JVM内存图
 */
public class FiledAndLocalVariables {
    static int s;
    int i;
    int j;
    {
        // 局部变量出栈就没了
        int i = 1;
        i++;
        // 成员变量
        j++;
        s++;
    }
    public void test(int j) {
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {
        FiledAndLocalVariables f1 = new FiledAndLocalVariables();
        FiledAndLocalVariables f2 = new FiledAndLocalVariables();
        f1.test(10);
        f1.test(20);
        f2.test(30);
        System.out.println(f1.i+","+f1.j+","+f1.s);
        System.out.println(f2.i+","+f2.j+","+f2.s);
    }
}
