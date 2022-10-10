package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/17 17:19:02
 */

/**
 * StringTable的垃圾回收
 * @apiNote jvm参数 -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 */
public class StringTableDemo6 {

  public static void main(String[] args) {
    int i = 0;
    try {
      for (int j = 0; j < 100060; j++) {
        String.valueOf(i).intern();
        i++;
      }
    } catch (Throwable e) {
      e.printStackTrace();
    } finally {
      System.out.println(i);
    }
  }
}
