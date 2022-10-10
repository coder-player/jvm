package com.fqh.structure;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/10 13:42:26
 */

import java.io.IOException;

/**
 * 堆,用来存放对象的内存空间 线程共享
 * 频繁在新生代收集,很少在老年代,几乎不在方法区收集
 */

/**
 * <ul> 对象分配流程
 * <li> 1.new的对象先放在Eden区,大小有限制
 * <li> 2.如果创建新的对象时,Eden空间满了,就会触发一个MinorGC,将Eden区不再被其他存活对象引用的对象进行销毁
 * <li> 3.将Eden区中剩余的对象转移到Survivor0区
 * <li> 4.再次触发垃圾回收,将上次幸存的对象,放在Survivor0区,
 * <li> 5.s0和s1来回复制存活对象
 * <li> 6.对象头里面的MarkWord存放着GC分代年龄,默认阈值15,也就是说一个对象经历了15次垃圾回收还存活的话,就会晋升为老年代对象
 * </ul>
 */
public class Heap {


    static int _4MB = 1024 * 1024 * 4;

    /**
     * <ul>
     * <li> 1.线程共享,整个java虚拟机只有一个堆,所有的线程都访问同一个堆
     * <li> 2.在虚拟机启动时创建
     * <li> 3.是垃圾回收的主要场所
     * <li> 4.堆可分为新生代(Eden区: Survivor-From Survivor-To),老年代
     * <li> 6.Survivor0和Survivor1: 复制之后有交换,空的是To
     * </ul>
     */
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[_4MB];
        System.in.read();
    }

}
