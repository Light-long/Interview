package com.tx.cas;

/**
 * CAS底层原理：
 * - UnSafe
 *  - rt.jar--com.misc.Unsafe.class
 *  - 根据内存偏移地址获取数据valueOffSet
 * - 自旋锁
 *  public final int getAndAddInt(Object var1, long var2, int var4) {
 *         int var5;
 *         do {
 *             var5 = this.getIntVolatile(var1, var2);
 *         } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
 *
 *         return var5;
 *     }
 *
 * 当且仅当主内存中的值与线程工作内存中的值相同时，改为修改值
 * 否则重新获取主内存中的值，继续比较
 */
public class CASDemo2 {
}
