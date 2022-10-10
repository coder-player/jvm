package com.fqh.java;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/21 22:03:00
 */

/**
 * SafePoint: 安全点
 */
public class SafePointDemo1 {

  public static AtomicInteger num = new AtomicInteger(0);

  /**
   * GC线程必须等用户线程进入Safepoint之后才进行工作
   * <ul>
   * <li> 1.可数(int)循环: 在可数循环下 线程会等循环结束之后才会进入Safepoint
   * <li> 2.不可数(long)循环: 在不可数循环下 线程在循环期间就能进入Safepoint
   * <li> 3.调用native函数后 返回到java线程后 必须进行一次safepoint的检测
   * <li> 4.
   * <li> 5.
   * <li> 6.
   * </ul>
   */
  public static void main(String[] args) throws InterruptedException {

    Runnable runnable = () -> {
      for (int i = 0; i < 200000000; i++) {
        num.getAndAdd(1);
        // prevent gc 出自RocketMq源码
//        if (i % 1000 == 0) {
//          try {
//            Thread.sleep(0); // sleep是native方法 这里就相当于放置了一个safepoint
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
//        }
      }
    };
    Thread t1 = new Thread(runnable, "T1");
    Thread t2 = new Thread(runnable, "T2");
    t1.start();
    t2.start();
    System.out.println("Main ===> sleep...");
    long start = System.currentTimeMillis();
    Thread.sleep(1000); // 主线程调用native方法后回来 发现安全点操作正在进行 把自己挂起 直到操作结束
    System.out.println("Main ===> weak up... : " + (System.currentTimeMillis() - start) + "ms");
    System.out.println("num: " + num);
  }



}
