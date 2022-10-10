package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/17 17:06:36
 */

import java.util.ArrayList;
import java.util.List;

/**
 * StringTable的位置 堆 java.lang.OutOfMemoryError: Java heap space
 * @since JDK 1.7
 * @apiNote jvm参数 -Xmx10m -XX:-UseGCOverheadLimit
 */
public class StringTableDemo5 {

  public static void main(String[] args) {

    List<String> list = new ArrayList<>();
    int i = 0;
    try {
      for (int j = 0; j < 260000; j++) {
        list.add(String.valueOf(j).intern());
        i++;
      }
    } catch (Throwable e) {
      e.printStackTrace();
    } finally {
      System.out.println(i);
    }
  }
}
