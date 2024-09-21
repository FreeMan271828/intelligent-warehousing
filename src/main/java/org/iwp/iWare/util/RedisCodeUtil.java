package org.iwp.iWare.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Component
public class RedisCodeUtil {

    private static StringRedisTemplate redisTemplate = null;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Autowired
    public RedisCodeUtil(StringRedisTemplate redisTemplate) {
        RedisCodeUtil.redisTemplate = redisTemplate;
    }

    public static String generateCode(Class<?> entityClass) {
        String key = "entity:" + entityClass.getSimpleName();
        String dateStr = LocalDate.now().format(formatter);
        String fullKey = key + ":" + dateStr;


        // 使用 INCR 命令生成序列号
        int index = Math.toIntExact(redisTemplate.opsForValue().increment(fullKey));

        // 格式化序列号为三位数
        String formattedIndex = String.format("%03d", index);

        // 生成编码
        String code = dateStr + formattedIndex;

        // 设置过期时间，每天重置序列号
        redisTemplate.expire(fullKey, 1, TimeUnit.DAYS);

        return code;
    }
}