package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/17 16:17:10
 */

/**
 * @see String#intern()
 * @since  JDK7 使用此方法加入字符串常量池的对象地址就是 原对象地址
 * @apiNote  JDK6 使用此方法加入字符串常量池的对象地址是 副本对象地址
 *
 */
public class StringTableDemo4 {

  public static void main(String[] args) {
    String x = "ab";
    // pool: {"a", "b"}
    String s = new String("a") + new String("b");
    // heap: new String("a") new String("b") new String("ab")
    // 尝试将字符串对象 放入字符串常量池 常量池存在equals的对象则返回地址, 不存在则放入常量池并放回地址
    String s2 = s.intern();
    System.out.println(s2 == x); // true jdk1.8
    System.out.println(s == x); // false
  }
}
