package com.fqh.java;

import java.io.IOException;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/18 21:56:32
 */

/**
 * 多态的原理
 * @apiNote jvm参数 禁用指针压缩 -XX:-UseCompressedOops -XX:-UseCompressedClassPointers
 */
public class MethodCallDemo1 {

  public static void test(Animal animal) {
    animal.eat();
    System.out.println(animal.toString());
  }

  public static void main(String[] args) throws IOException {
    test(new Cat());
    test(new Dog());
//    System.in.read();
  }
}
