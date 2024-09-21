package org.iwp.iWare.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogUtil {

    private static Logger LOG;

    public LogUtil() {
        // 获取调用栈
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        // 遍历调用栈，找到调用当前方法的类
        for (StackTraceElement element : stackTraceElements) {
            if (element.getClassName().equals(LogUtil.class.getName())) {
                // 调用者索引通常是当前方法的调用者
                String callerClassName = stackTraceElements[stackTraceElements.length - 2].getClassName();
                LOG = LoggerFactory.getLogger(callerClassName);
                break;
            }
        }
    }

    public static void info(String msg) {
        LOG.info(msg);
    }

    public static void warn(String msg) {
        LOG.warn(msg);
    }

    public static void error(String msg) {
        LOG.error(msg);
    }

    public static void debug(String msg) {
        LOG.debug(msg);
    }
}
