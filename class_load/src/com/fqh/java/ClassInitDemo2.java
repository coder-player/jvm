package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/26 19:10:26
 */
public class ClassInitDemo2 {

  static class ConstClass {
    static {
      System.out.println("ConstClass init!");
    }
    public static final String HELLO_BINGO = "Hello Bingo";
  }

  public static void main(String[] args) {
    // 常量在编译器阶段会存入调用类的常量池 本质上并没有直接引用到定义常量的类 不会触发类的初始化
    System.out.println(ConstClass.HELLO_BINGO);
  }
}
