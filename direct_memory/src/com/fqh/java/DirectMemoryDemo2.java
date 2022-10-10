package com.fqh.java;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/17 19:47:20
 */
public class DirectMemoryDemo2 {

  static int _1GB = 1024 * 1024 * 1024;

  public static void main(String[] args) throws IOException {
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1GB);
    System.out.println("直接内存分配完毕...");
    System.in.read();
    System.out.println("开始释放直接内存...");
    byteBuffer = null;
    System.gc();
  }
}
