package org.iwp.iWare.util;

public interface RedisCodeMaker {
    String generateCode(Class<?> entityClass);
}
