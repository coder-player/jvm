package com.fqh.structure;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/10 13:56:36
 */

/**
 * 方法区(永久代/元空间) 线程共享 <br>
 * <b>
 *   内存回收效率低,方法区中的信息一般需要长期存在,主要回收目标是: 常量池的回收(废弃常量),对类的卸载
 * </b>
 *
 */
public class MethodArea {
    /**
     * <ul> 方法区是jvm规范的一个逻辑部分,方法区存放以下信息:
     * <li> 1.已经被虚拟机加载的类信息
     * <li> 2.常量
     * <li> 3.静态变量
     * <li> 4.即时编译器编译后的代码
     * </ul>
     */
    public static void main(String[] args) {
        String s = new String("hello");
        s.intern(); // 加入字符串常量池 ===> 加入运行时常量池
    }
}
