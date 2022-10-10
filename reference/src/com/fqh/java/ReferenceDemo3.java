package com.fqh.java;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/18 14:13:56
 */

/**
 * 弱引用
 * @apiNote jvm参数 -Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class ReferenceDemo3 {

  public static final int _4MB = 4 * 1024 * 1024;

  public static void main(String[] args) {

    List<WeakReference<byte[]>> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB]);
      list.add(ref);
      for (WeakReference<byte[]> weakReference : list) {
        System.out.print(weakReference.get() + " ");
      }
      System.out.println();
    }
    System.out.println("Cycle Over: " + list.size());
  }
}
