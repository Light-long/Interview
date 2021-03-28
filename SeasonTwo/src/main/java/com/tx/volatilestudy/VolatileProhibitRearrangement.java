package com.tx.volatilestudy;

/**
 * volatile禁止指令重排
 *
 * 指令重排
 * 源代码--编译器优化重排--指令并行重排--内存系统的重排--最终的指令
 * 处理器在进行重排序时需要考虑指令之间的数据依赖性
 * 多线程环境中线程交替执行，由于编译器优化重排的存在，两个线程中使用的变量能否保证一致性是无法确定的，结果无法预测
 */
public class VolatileProhibitRearrangement {
}
