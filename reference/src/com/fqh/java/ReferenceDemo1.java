package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/18 13:33:04
 */

/**
 * 四种引用
 * <ul>
 * <li> 1.强引用: 普遍存在于代码的引用赋值 只有强引用关系还存在 就不会被垃圾回收
 * <li> 2.软引用: 关联一些还有用 但非必须的对象 这些对象在内存不足的时候会被回收
 * <li> 3.弱引用: 只要发生垃圾回收动作 这些对象就会被回收
 * <li> 4.虚引用: 设置虚引用的目的是在垃圾回收时收到一个系统通知 ByteBuffer的Cleaner对象就是虚引用
 * </ul>
 */
public class ReferenceDemo1 {

  // ByteBuffer分配的直接内存 在ByteBuffer垃圾回收时
  // 一个finalizer线程会通知引用队列的虚引用Cleaner
  // 调用内部task的run方法 执行unsafe的free方法释放直接内存
  public static void main(String[] args) {

  }
}
