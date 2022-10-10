package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/26 19:05:59
 */
public class ClassInitDemo1 {

  public static void main(String[] args) {
    // 子类引用父类的静态字段 触发父类初始化 不会触发子类初始化
    System.out.println(SubClass.value);
    // 定义数组类型 不会触发初始化 底层操作字节码指令newarray
    SuperClass[] superClasses = new SuperClass[10];
  }

  static class SuperClass {
    static {
      System.out.println("SuperClass init!");
    }
    public static int value = 123;
  }

  static class SubClass extends SuperClass {
    static {
      System.out.println("SubClass init!");
    }
  }
}


