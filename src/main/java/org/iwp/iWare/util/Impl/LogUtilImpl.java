package org.iwp.iWare.util.Impl;

import org.iwp.iWare.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogUtilImpl implements LogUtil {

    private Logger LOG;

    public LogUtilImpl() {
        // 获取调用栈
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        // 遍历调用栈，找到调用当前方法的类
        for (StackTraceElement element : stackTraceElements) {
            if (element.getClassName().equals(LogUtilImpl.class.getName())) {
                // 调用者索引通常是当前方法的调用者
                String callerClassName = stackTraceElements[stackTraceElements.length - 2].getClassName();
                LOG = LoggerFactory.getLogger(callerClassName);
                break;
            }
        }
    }

    @Override
    public void info(String msg) {
        LOG.info(msg);
    }

    @Override
    public void warn(String msg) {
        LOG.warn(msg);
    }

    @Override
    public void error(String msg) {
        LOG.error(msg);
    }

    @Override
    public void debug(String msg) {
        LOG.debug(msg);
    }
}
