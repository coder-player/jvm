package com.fqh.java;

import java.util.ArrayList;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/20 21:48:15
 */

/**
 * 垃圾收集器: Parallel(复制算法) + Parallel Old(标记整理)
 * @apiNote jvm参数 -XX:+PrintCommandLineFlags
 * @since JDK8
 */
public class GarbageCollectionDemo2 {

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
