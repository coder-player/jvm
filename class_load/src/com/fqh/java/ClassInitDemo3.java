package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/26 19:20:11
 */

/**
 * 类加载 第三阶段 ===> 初始化<br>
 * 执行类构造器<clinit>()方法: 自动收集类中的所有类变量赋值动作和static{}块中的语句 进行合并执行<br>
 * 如果一个类没有静态成员变量和static{} 那么不会生成<clinit>()方法
 */
public class ClassInitDemo3 {
  static {
    i = 0; // 给变量赋值编译可以通过
//    System.out.println(i); // 非法向前引用
  }
  static int i = 1;

  static class Parent {
    public static int A = 1;
    static {
      A = 2;
    }
  }

  static class Sub extends Parent {
    public static int B = A;
  }

  public static void main(String[] args) {
    System.out.println(Sub.B);
  }
}
