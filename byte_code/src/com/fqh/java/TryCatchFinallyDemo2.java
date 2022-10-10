package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/19 17:36:19
 */
public class TryCatchFinallyDemo2 {

  public static void main(String[] args) {
//    int result = test();
    int result = test1();
    System.out.println(result);
  }

  public static int test() {
    try {
      return 10;
    } finally {
      return 20; // finally块中 写了return 会吞掉移除
    }
  }

  public static int test1() {
    try {
      int i = 1 / 0;
      return 10;
    } finally {
      return 20;
    }
  }

  /**
   * test() 字节码分析
   *   Code:
   *       stack=1, locals=2, args_size=0
   *          0: bipush        10     // <=== 10 放入栈顶
   *          2: istore_0             // 10 ===> slot 0 (从栈顶移除)
   *          3: bipush        20     // <=== 20 放入栈顶
   *          5: ireturn              // 弹栈 int(20)
   *          6: astore_1             // catch any ===> slot 1
   *          7: bipush        20     // <=== 20 放入栈顶
   *          9: ireturn              // 弹栈 int(20)
   */
}
