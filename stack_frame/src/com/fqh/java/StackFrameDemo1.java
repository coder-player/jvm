package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/17 14:12:00
 */

/**
 * 虚拟机栈的局部变量 线程安全问题
 */
public class StackFrameDemo1 {

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    sb.append(4);
    sb.append(5);
    sb.append(6);
    new Thread(() -> {
      m2(sb);
    }, "T1").start();

  }

  /**
   * sb作为局部变量 并且没有发生逃逸 线程安全
   */
  public static void m1() {
    StringBuilder sb = new StringBuilder();
    sb.append(1);
    sb.append(2);
    sb.append(3);
    System.out.println(sb.toString());
  }

  /**
   * sb作为对象传参 线程不安全
   * @param sb
   */
  public static void m2(StringBuilder sb) {
    sb.append(1);
    sb.append(2);
    sb.append(3);
    System.out.println(sb.toString());
  }

  /**
   * sb作为(对象)局部变量 发生逃逸 线程不安全
   * @return
   */
  public static StringBuilder m3() {
    StringBuilder sb = new StringBuilder();
    sb.append(1);
    sb.append(2);
    sb.append(3);
    return sb;
  }
}
