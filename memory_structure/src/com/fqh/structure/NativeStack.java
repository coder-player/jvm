package com.fqh.structure;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/10 13:39:18
 */

/**
 * 本地方法栈(C栈) 线程私有
 */
public class NativeStack {

    /**
     * <ul> JVM运行Native方法准本的空间,大多数native方法都是C语言实现的
     * <li> 1.线程私有的
     * </ul>
     */
    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(1000); // native
        Object obj = new Object();
        System.out.println(obj.hashCode()); // native

    }
}
