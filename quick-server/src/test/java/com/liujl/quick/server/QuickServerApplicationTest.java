package com.liujl.quick.server;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Quick Server 启动类基础测试，用于在 CI 中确认主应用类可被测试运行时正常加载。
 *
 * 作者：liujl
 * 创建时间：2026-06-03 11:10:07
 */
class QuickServerApplicationTest {

    /**
     * 校验主应用类可被 JVM 加载，避免入口类包名、类名或测试依赖调整后没有最小反馈。
     *
     * 作者：liujl
     * 创建时间：2026-06-03 11:10:07
     */
    @Test
    void applicationClassShouldBeLoadable() {
        assertNotNull(QuickServerApplication.class);
    }

}
