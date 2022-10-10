package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/19 14:21:47
 */
public class StringTableDemo7 {

  public static void main(String[] args) {

    String s = new String("1");
    s.intern(); // 将"1"对象加入常量池
    String s2 = "1"; // 常量池有"1" 返回常量池的对象
    System.out.println(s == s2); // false   堆上地址 != 常量池的对象地址

    String s3 = new String("1") + new String("1"); // StringBuilder.append("1").append("1").toString
    s3.intern();  // 将"11"对象加入常量池
    String s4 = "11"; // 从常量池拿到"11"对象
    System.out.println(s3 == s4); // true
  }
}
