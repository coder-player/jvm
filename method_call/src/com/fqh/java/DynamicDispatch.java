package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/18 17:40:58
 */

/**
 * 分派调用 ===> 动态分派
 */
public class DynamicDispatch {

  static abstract class Human {

    protected abstract void sayHello();
  }

  static class Man extends Human {
    @Override
    protected void sayHello() {
      System.out.println("man sayHello");
    }
  }

  static class Women extends Human {
    @Override
    protected void sayHello() {
      System.out.println("women sayHello");
    }
  }

  public static void main(String[] args) {
    Human man = new Man();
    Human women = new Women();
    man.sayHello();
    women.sayHello();
    man = new Women();
    man.sayHello();
  }
}
