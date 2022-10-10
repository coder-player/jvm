package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/19 19:50:41
 */
public class SugarDemo1 {

  static final Object obj = new Object();

  public static void main(String[] args) {

    synchronized (obj) {
      System.out.println("ok");
      int i = 1 / 0;
    }

//    test();
  }


  public static synchronized void test() {
    System.out.println("hello world");
    synchronized (SugarDemo1.class) {
      System.out.println("hello 2");
      synchronized (SugarDemo1.class) {
        System.out.println("hello 3");
      }
    }
  }
}
