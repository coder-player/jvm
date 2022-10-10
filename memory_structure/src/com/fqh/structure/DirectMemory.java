package com.fqh.structure;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/10 14:03:35
 */

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * 直接内存(堆外内存)
 * NIO
 */
public class DirectMemory {

    /**
     * <ul> 直接内存 vs 堆内存
     * <li> 1.直接内存申请空间耗费更高性能
     * <li> 2.直接内存读取IO性能优于普通的堆内存
     * <li> 3.直接内存作用链: 本地IO->直接内存->本地IO
     * <li> 4.堆内存作用链: 本地IO->直接内存->非直接内存->直接内存->本地IO
     * </ul>
     */
    public static void main(String[] args) throws IOException {
        // 申请直接内存
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        System.in.read();
    }
}
