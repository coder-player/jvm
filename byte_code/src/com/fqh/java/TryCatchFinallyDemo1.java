package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/19 17:18:43
 */

/**
 * finally语句块的原理
 */
public class TryCatchFinallyDemo1 {

  public static void main(String[] args) {
    int i = 0;
    try {
      i = 10;
    } catch (Exception e) {
      i = 20;
    } finally {
      i = 30;
    }
    System.out.println(i);
  }

  /**
   * finally块的字节码在try块 catch块都被放置了一份 以确保finally块的代码一定会执行
   *          0: iconst_0
   *          1: istore_1      =============
   *          2: bipush        10   正常分支
   *          4: istore_1      =============
   *          5: bipush        30 ---> i = 30;
   *          7: istore_1
   *          8: goto          27
   *         11: astore_2      =============
   *         12: bipush        20   异常分支
   *         14: istore_1      =============
   *         15: bipush        30 ---> i = 30;
   *         17: istore_1
   *         18: goto          27
   *         21: astore_3
   *         22: bipush        30 ---> i = 30;
   *         24: istore_1
   *         25: aload_3
   */

}
