package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/18 17:23:52
 */

/**
 * 分派调用 ===> 静态分派
 */
public class StaticDispatch {

  static abstract class Human {

  }

  static class Man extends Human {

  }

  static class Women extends Human {

  }

  public void sayHello(Human guy) {
    System.out.println("hello guy");
  }

  public void sayHello(Man man) {
    System.out.println("hello gentleman");
  }

  public void sayHello(Women women) {
    System.out.println("hello lady");
  }

  // jvm在编译期调用重载方法是根据静态类型 也就是等号左边的类型 来匹配重目标载方法参数的类型
  public static void main(String[] args) {
    // 静态类型 o = new 动态类型
    Human man = new Man();
    Human women = new Women();
    StaticDispatch dispatch = new StaticDispatch();
    // 重载方法sayHello jvm会根据类型Human找到 sayHello(Human guy)调用
    dispatch.sayHello(man);
    dispatch.sayHello(women);
  }
}
