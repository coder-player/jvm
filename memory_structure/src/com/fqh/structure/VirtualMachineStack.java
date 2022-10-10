package com.fqh.structure;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/10 13:30:34
 */

/**
 * 虚拟机栈(Java栈) 线程私有
 */
public class VirtualMachineStack {

    public static void main(String[] args) {
        int k = 0;
        m1();
    }

    /**
     * <ul> java虚拟机栈是描述java方法运行过程的内存模型
     * <li> 1.java虚拟机栈会为每一个即将运行的方法创建"栈帧",用来存放该方法运行过程中的一些信息
     * <li> 2.局部变量表: 八大原始类型,对象引用,returnAddress
     * <li> 3.操作数栈: 栈顶缓存技术,操作数栈是存储在内存中,频繁进行内存读写影响执行速度,将栈顶元素缓存到物理CPU的寄存器
     * <li> 4.动态链接: 方法无法在编译器被确定下来,只能在允许其根据实际的类型绑定相关的方法
     * <li> 5.方法出口信息
     * </ul>
     */
    public static void m1() {
        int a = 1;
        int res = m2() + a;
        System.out.println(res);
    }

    public static int m2() {
        return 999;
    }
}
