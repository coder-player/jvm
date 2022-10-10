package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/20 22:01:30
 */

import java.util.ArrayList;

/**
 * 垃圾收集器: CMS 老年代(标记清除) 并发收集 + 低延迟(STW短) <br>
 * jvm参数 -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC <br>
 * <br>
 * 执行流程: <br>
 *          ===> 初始标记STW(仅仅标记GCRoot对象直接关联的对象) <br>
 *          ===> 并发标记(标记线程与用户线程并发运行) <br>
 *          ===> 重新标记STW(并发标记中用户线程可能对某些标记对象的引用进行了更改 需要修正标记) <br>
 *          ===> 并发清除(并发清除已标记为垃圾的对象)
 *
 */

public class GarbageCollectionDemo3 {
  /**
   * CMS弊端 <br>
   * 浮动垃圾: 并发标记和并发清除期间 用户线程产生的垃圾 CMS无法处理 只能等到下一次垃圾回收时标记
   * <ul>
   * <li> 1.面向并发设计的程序对CPU资源非常敏感 在多核CPU才能发挥最大作用 并且我们用户线程消耗的资源变少 总吞吐量下降
   * <li> 2.CMS无法处理"浮动垃圾" 可能分配空间失败 导致完全STW的Full GC的产生
   * <li> 3.基于标记清除算法 会有内存碎片化问题 可能无法分配大对象 导致Full GC
   * </ul>
   */
  public static void main(String[] args) {

    ArrayList<byte[]> list = new ArrayList<>();
    int i = 0;
    try {
      while (true) {
        byte[] arr = new byte[100];
        list.add(arr);
        i++;
      }
    } finally {
      System.out.println(i);
    }
  }

}
