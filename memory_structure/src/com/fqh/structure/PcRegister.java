package com.fqh.structure;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/10 13:23:55
 */

/**
 * 程序计数器(PC寄存器) 线程私有
 *
 */
public class PcRegister {

    /**
     * <ul> 程序计数器是较小的内存空间 保存当前线程正在执行的字节码指令的地址
     * <li> 1.字节码解释器通过改变程序计数器来依次读取指令, 从而实现代码流程控制
     * <li> 2.多线程情况下,程序计数器记录的是当前线程执行的位置,线程上下文切换回来,就知道线程执行到哪了
     * <li> 3.是一块较小的内存空间
     * <li> 4.唯一一个不会出现OOM的内存区域
     * <li> 5.生命周期: 随着线程的创建而创建,随着线程的结束而销毁
     * <li> 6.线程私有: 每个线程都有自己的程序计数器
     * </ul>
     */
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
