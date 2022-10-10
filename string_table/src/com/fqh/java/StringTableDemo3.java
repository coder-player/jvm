package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/17 16:06:06
 */

/**
 * 字符串的延迟加载 DEBUG Memory
 */
public class StringTableDemo3 {

  public static void main(String[] args) {

    int x = args.length;
    System.out.println(); // 字符串个数

    System.out.println("1"); // 2151
    System.out.println("2");
    System.out.println("3");
    System.out.println("4");
    System.out.println("5");
    System.out.println("6");
    System.out.println("7");
    System.out.println("8");
    System.out.println("9");
    System.out.println("0");
    System.out.println("1"); // 字符串个数 2161
    System.out.println("2");
    System.out.println("3");
    System.out.println("4");
    System.out.println("5");
    System.out.println("6");
    System.out.println("7");
    System.out.println("8");
    System.out.println("9");
    System.out.println("0"); // 字符串个数 2161

    System.out.println(x);
  }
}
