package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/17 19:52:24
 */

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * 直接内存 分配 释放
 */
public class DirectMemoryDemo3 {

  static int _1GB = 1024 * 1024 * 1024;

  public static void main(String[] args) throws IOException {
    Unsafe unsafe = getUnsafe();
    // 分配内存
    long base = unsafe.allocateMemory(_1GB);
    unsafe.setMemory(base, _1GB, (byte) 0);
    System.in.read();

    // 释放内存
    unsafe.freeMemory(base);
    System.in.read();
  }

  public static Unsafe getUnsafe() {
    try {
      Field f = Unsafe.class.getDeclaredField("theUnsafe");
      f.setAccessible(true);
      Unsafe unsafe = (Unsafe) f.get(null);
      return unsafe;
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
}
