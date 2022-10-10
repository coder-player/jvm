package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/22 17:11:38
 */

/**
 * G1垃圾收集器
 * @since JDK9
 */
public class GarbageCollectionDemo4 {

  /**
   * G1如何解决跨代引用: Card Table(卡表) + Remembered Set(记忆集) + Dirty Card Queue(脏卡队列)<br>
   * G1跟踪引用指针流程: 每次对引用对象进行赋值操作时,jvm会加入一个写屏障 将当前引用与引用指向写入CardTable,同时填充脏卡队列,当脏卡队列超过white区域,jvm就会启动一个细分线程来更新我们的RememberedSet<br>
   * 为什么修改引用时不立即更新RememberedSet? 并发线程安全问题<br>
   * <ul>
   * <li> 1.Card Table: 它告诉特定区域内哪个位置的对象指向这个区域
   * <li> 2.Remembered Set: 记录了外部的引用指向 ===> 特定Eden区域对象的 所有外部对象地址
   * <li> 3.写屏障: jvm注入到代码中的一小段代码 每次做引用赋值操作时加入
   * <li> 4.Dirty Card Queue: 四个区域 white green yellow red
   * </ul>
   */

  public static void main(String[] args) {

  }

}
