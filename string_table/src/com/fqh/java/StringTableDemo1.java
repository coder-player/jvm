package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/17 15:33:18
 */

/**
 * 字符常量池表测试
 */
public class StringTableDemo1 {

  public static void main(String[] args) {

    String s1 = "a"; // 加载并放入常量池 "a"
    String s2 = "b"; // 加载并放入常量池 "b"
    String s3 = "a" + "b"; // 加载并放入常量池 "ab"
    String s4 = s1 + s2; // 编译后 ===> new StringBuilder().append("a").append("b").toString() ===> new String()
    String s5 = "ab"; // 加载常量池"ab"
    String s6 = s4.intern();

    // qs
    System.out.println(s3 == s4); // false
    System.out.println(s3 == s5); // true
    System.out.println(s3 == s6); // ture

    String x2 = new String("c") + new String("d");
    x2.intern();
    String x1 = "cd";
//    x2.intern();
    // qs: 调换最后两行代码的位置? ===> true jdk1.6? ===> false [jdk1.6的intern方法放入常量池的是字符串副本地址]
    System.out.println(x1 == x2);
  }
}
