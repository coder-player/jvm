package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/19 20:01:03
 */

/**
 * 运行期优化 逃逸分析
 * @apiNote jvm参数 -XX:+PrintCompilation -XX:-DoEscapeAnalysis
 *
 */
public class RuntimeOptimizeDemo1 {

  public static void main(String[] args) {
    for (int i = 0; i < 200; i++) {
      long start = System.nanoTime();
      for (int j = 0; j < 1000; j++) {
        new Object();
      }
      long end = System.nanoTime();
      System.out.println("循环次数: " + i + " 耗时: " + (end - start));
    }
  }
}
