package cn.ljlin233.redisclusterdemo;

import java.sql.Timestamp;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lvjinlin@yunrong.cn
 * @version V2.1
 * @date 2019/7/30 16:59
 * @since 2.1.0
 */
@Service
@Slf4j
public class CacheService {

    /**
     * 在方法执行前，Spring先查看缓存中是否有数据。如果有数据，则直接返回缓存数据；
     * 若没有数据，调用方法并将方法返回值放进缓存。
     * ？？？方法进入2此
     */
    @Cacheable(value = "rediscache", key = "111")
    public long getByCache() {
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();

        log.info("@Cacheable缓存 方法耗时: " + timestamp);
        System.out.println("@Cacheable缓存 方法耗时: " + timestamp);

        return timestamp;
    }

    /**
     * 与 @Cacheable 类似，但是它无论什么情况，都会将方法的返回值放到缓存中。
     * 主要用于数据新增和修改方法
     * @return null
     */
    @CachePut(value = "rediscache", key = "111")
    public long save() {
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        log.info("@CachePut缓存 方法耗时: " + timestamp);
        return timestamp;
    }

    /**
     * 将一条或多条数据从缓存中删除。主要用于删除方法，用来从缓存中移除相应数据
     * 删除命名空间中的缓存
     */
    @CacheEvict(value = "rediscache", key = "111")
    public void delete() {
        log.info("删除缓存");
    }

}
