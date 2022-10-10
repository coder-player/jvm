package com.fqh.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/18 13:11:49
 */

/**
 * GC ROOT对象
 * <ul>
 * <li> 1.虚拟机栈中引用的对象
 * <li> 2.方法区中类静态属性引用的对象
 * <li> 3.字符串常量池(String Table)引用的对象
 * <li> 4.本地方法栈中Native方法引用的对象
 * <li> 5.java虚拟机内部的引用 Class对象 异常 系统类加载器
 * <li> 6.被同步锁(synchronized关键字)持有的对象
 * </ul>
 */
public class GarbageCollectionDemo1 {

  public static void main(String[] args) throws IOException {
    List<Object> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    System.out.println();
    System.in.read();

    list = null;
    System.out.println(2);
    System.in.read();
    System.out.println("END...");
  }

}
