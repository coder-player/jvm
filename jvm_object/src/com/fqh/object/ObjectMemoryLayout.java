package com.fqh.object;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/10 14:11:07
 */

/**
 * <ul> 对象的内存布局
 * <li> 1.对象头: markWord和KClassPoint类型指针
 * <li> 2.实例数据: 对象实例数据大小
 * <li> 3.对齐填充(可选): 确保对象的总长度为8字节的整数倍
 * </ul>
 */
public class ObjectMemoryLayout {

    /**
     * <ul> 对象头 MarkWord存储的数据
     * <li> 1.哈希码
     * <li> 2.GC分代年龄
     * <li> 3.锁状态标志
     * <li> 4.线程持有的锁
     * <li> 5.偏向线程ID
     * <li> 6.偏向时间戳
     * </ul>
     */
    public static void main(String[] args) {
        Object obj = new Object();
        // KClass类型指针 通过指针能确定对象属于那个类
        System.out.println(obj.hashCode());
        // 实例数据部就是成员变量,包括父类成员变量和本类成员变量
    }
}
