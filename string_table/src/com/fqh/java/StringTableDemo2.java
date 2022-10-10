package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/17 15:45:03
 */

/**
 * StringTable 哈希结构
 */
public class StringTableDemo2 {

  // 常量池中的信息, 都会被加载到运行时常量池中, 这是a b ab都是常量池的符号, 还没有变为 java字符串对象
  // ldc#2 将a符号 ===> 变为"a"字符串对象
  // ldc#3 将b符号 ===> 变为"b"字符串对象
  // ldc#4 将ab符号 ===> 变为"ab"字符串对象

  public static void main(String[] args) {
    String s1 = "a";
    String s2 = "b";
    String s3 = "ab";
    // 字符串变量的拼接 ===> (new StringBuilder()).append(s1).append(s3).toString(); new String("ab")
    String s4 = s1 + s3;
    // 编译器优化 ===> String s5 = "ab";
    String s5 = "a" + "b";
    System.out.println(s3 == s5); // true
    System.out.println(s3 == s4); // false
  }
}
