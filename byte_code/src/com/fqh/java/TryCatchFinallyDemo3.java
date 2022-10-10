package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/19 17:59:22
 */
public class TryCatchFinallyDemo3 {

  public static void main(String[] args) {
    int result = test();
    System.out.println(result);
  }

  public static int test() {
    int i = 10;
    try {
      return i;
    } finally {
      i = 20;
    }
  }
}
