package com.fqh.object;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/10 14:17:04
 */

/**
 * 对象的创建过程
 */
public class ObjectCreateProcess {
    // 类加载检查
    // jvm在解析.class文件时,遇到一条new指令,
    // 首先会检查常量池是否有这个类型的符号引用
    // 并且检查这个符号引用所代表的类是否已经被加载,解析和初始化过
    // 如果没有,则执行类加载过程

    /**
     * <ul> 对象分配内存方式
     * <li> 1.指针碰撞: 堆内存布局绝对规整(采用<b>复制算法<b/>或<b>标记整理法</b>),通过将指针向空闲的内存移动一段与对象大小一样的距离
     * <li> 2.空闲列表: 堆内存并不规整(采用<b>标记-清除算法<b/>,有内存碎片),没办法进行指针碰撞,jvm维护一个列表,记录其中哪些内存块空闲可用,分配时从空闲列表中找到一块足够大的空间划分给对象实例
     * </ul>
     */
    public static void main(String[] args) {
        // 初始化: 分配内存后,为对象中的成员变量赋初始值,设置对象头信息,调用对象的构造函数进行初始化
        Animal animal = new Dog();
        animal.eat();
    }

    static abstract class Animal {

        public abstract void eat();
    }

    static class Dog extends Animal {

        @Override
        public void eat() {
            System.out.println("Dog eat shit");
        }
    }
}
