package cn.lenjoy.boot.framework.redis.util;

import cn.lenjoy.boot.framework.common.util.AssertUtils;
import cn.lenjoy.boot.framework.common.util.object.ObjectUtils;
import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * @description: Redis 工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 16 星期六
 * @version: 1.0.0
 */
@SuppressWarnings("unused")
public class RedisUtils {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 判断key是否存在
     * @param key 键
     * @return 是否存在
     */
    public boolean hasKey(String key) {
        try {
            AssertUtils.notFalse(StringUtils.isBlank(key), "判断key是否存在，参数异常");
            return Boolean.TRUE.equals(redisTemplate.hasKey(key));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 删除缓存
     * @param key 键
     * @return 是否成功
     */
    public boolean del(String key) {
        try {
            AssertUtils.notFalse(StringUtils.isBlank(key), "删除缓存，参数异常");
            return Boolean.TRUE.equals(redisTemplate.delete(key));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        try {
            AssertUtils.notFalse(StringUtils.isBlank(key), "获取缓存，参数异常");
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 设置缓存
     *
     * @param key   键
     * @param value 值
     * @return 是否成功
     */
    public boolean set(String key, Object value) {
        try {
            AssertUtils.notFalse(StringUtils.isBlank(key) || ObjectUtils.isEmpty(value), "设置缓存，参数异常");
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置缓存、设置过期时间、单位秒
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return 是否成功
     */
    public boolean set(String key, Object value, long time) {
        try {
            AssertUtils.notFalse(StringUtils.isBlank(key) || ObjectUtils.isEmpty(value) || ObjectUtils.isEmpty(time) || time < 0, "设置缓存、设置过期时间、单位秒，参数异常");
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置缓存、设置过期时间和单位
     *
     * @param key   键
     * @param value 值
     * @param time  时间
     * @param unit  时间单位
     * @return 是否成功
     */
    public boolean set(String key, Object value, long time, TimeUnit unit) {
        try {
            AssertUtils.notFalse(StringUtils.isBlank(key) || ObjectUtils.isEmpty(value) || ObjectUtils.isEmpty(time) || ObjectUtils.isEmpty(unit), "设置缓存、设置过期时间和单位，参数异常");
            redisTemplate.opsForValue().set(key, value, time, unit);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 指定缓存失效时间、单位秒
     * @param key 键
     * @param time 时间(秒)
     * @return 是否成功
     */
    public boolean expire(String key, long time) {
        try {
            AssertUtils.notFalse(StringUtils.isBlank(key) || ObjectUtils.isEmpty(time), "指定缓存失效时间、单位秒，参数异常");
            return Boolean.TRUE.equals(redisTemplate.expire(key, time, TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 指定缓存失效时间、单位
     * @param key 键
     * @param time 时间(秒)
     * @param unit  时间单位
     * @return 是否成功
     */
    public boolean expire(String key, long time, TimeUnit unit) {
        try {
            AssertUtils.notFalse(StringUtils.isBlank(key) || ObjectUtils.isEmpty(time), "指定缓存失效时间、单位秒，参数异常");
            return Boolean.TRUE.equals(redisTemplate.expire(key, time, unit));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 私有构造方法
     */
    private RedisUtils() {}
}
