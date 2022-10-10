package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/17 14:53:31
 */

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 演示元空间oom
 * @apiNote -XX:MaxMetaspaceSize=8m
 * @see Exception in thread "main" java.lang.OutOfMemoryError: Compressed class space
 */
public class MethodAreaDemo1 extends ClassLoader{ // 加载类的二进制字节码

  public static void main(String[] args) {

    int j = 0;
    try {
      MethodAreaDemo1 test = new MethodAreaDemo1();
      for (int i = 0; i < 10000; i++, j++) {
        // ClassWriter ===> 生成类的二进制字节码
        ClassWriter cw = new ClassWriter(0);
        // 版本号 访问修饰符 类名 包名 父类 接口
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
        // 返回字节码byte数组
        byte[] code = cw.toByteArray();
        // defineClass只会触发类的加载
        test.defineClass("Class" + i, code, 0, code.length);
      }
    } catch (Throwable e) {
      e.printStackTrace();
    } finally {
      System.out.println(j);
    }
  }
}
