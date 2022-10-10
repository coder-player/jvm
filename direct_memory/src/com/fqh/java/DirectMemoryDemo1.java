package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/17 19:34:40
 */

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 直接内存 常用于NIO操作 用户数据缓冲区
 * 直接内存溢出
 * @see Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
 */
public class DirectMemoryDemo1 {

  static int _100MB = 1024 * 1024 * 100;

  public static void main(String[] args) {
    List<ByteBuffer> list = new ArrayList<>();
    int i = 0;
    try {
      while (true) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(_100MB);
        list.add(buffer);
        i++;
      }
    } finally {
      System.out.println(i);
    }
  }

}
