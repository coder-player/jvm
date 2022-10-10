package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/18 13:45:06
 */

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 软引用
 * @apiNote jvm参数 -Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class ReferenceDemo2 {

  public static final int _4MB = 4 * 1024 * 1024;

  public static void main(String[] args) throws IOException {
//    List<byte[]> list = new ArrayList<>();
//    for (int i = 0; i < 5; i++) {
//      list.add(new byte[_4MB]);
//    }
//    System.in.read();
    soft();
  }

  /**
   * 一次垃圾回收内存还是不够 ===> 回收软引用对象
   */
  public static void soft() {
    // list ===> SoftReference ===> byte[]
    List<SoftReference<byte[]>> list = new ArrayList<>();

    // 引用队列
    ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
    for (int i = 0; i < 5; i++) {
      // 关联引用队列 当软引用所关联的byte[]被回收时 软引用自己就会被加入到引用队列
      SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB], queue);
      System.out.println(ref.get());
      list.add(ref);
      System.out.println(list.size());
    }
    System.err.println("Cycle Over: " + list.size());

    Reference<? extends byte[]> poll = queue.poll();
    while (poll != null) {
      list.remove(poll);
      poll = queue.poll();
    }
    for (SoftReference<byte[]> reference : list) {
      System.err.println(reference.get());
    }
  }
}
