package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/17 14:57:16
 */

import java.util.ArrayList;

/**
 * 堆的oom 内存溢出
 * @apiNote jvm参数 -Xmx8m 堆最大大小
 */
public class HeapDemo1 {

  public static void main(String[] args) {

    int i = 0;
    ArrayList<String> list = new ArrayList<>();
    try {
      while (true) {
        String s = "hello";
        s = s + s;
        list.add(s);
        i++;
      }
    } catch (Throwable e) {
      e.printStackTrace();
      System.out.println(i);
    }

  }
}
