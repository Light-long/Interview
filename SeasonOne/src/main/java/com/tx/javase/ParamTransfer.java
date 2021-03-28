package com.tx.javase;

import java.util.Arrays;

/**
 * 方法的传参机制
 * - 基本数据类型：复制相同的值给形参
 * - 引用数据类型：地址值
 *
 * tips:String类，包装类都具有不可变性
 */
public class ParamTransfer {
    public static void main(String[] args) {
        int i = 1;
        // 字符串不可变性
        String str = "hello";
        // final修饰，Integer重新赋值会产生一个新的对象并指向它
        Integer num = 200;
        int[] array = {1,2,3,4,5};
        MyData my = new MyData();

        change(i,str,num,array,my);
        // 1
        System.out.println("i="+i);
        // hello
        System.out.println("str="+str);
        // 200
        System.out.println("num="+num);
        // [2,2,3,4,5]
        System.out.println("array="+ Arrays.toString(array));
        // 11
        System.out.println("my="+my.a);
    }

    public static void change(int j,String s,Integer n,int[] a,MyData m) {
        j += 1;
        s += "world";
        n += 1;
        a[0] += 1;
        m.a += 1;
    }
}

class MyData {
    int a = 10;
}
