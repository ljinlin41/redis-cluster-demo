package cn.ljlin233.redisclusterdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvjinlin@yunrong.cn
 * @version V2.1
 * @date 2019/7/30 17:17
 * @since 2.1.0
 */
@RestController
@RequestMapping(value = "/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    /**
     * 查询方法
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void getByCache() {
        this.cacheService.getByCache();
    }

    /**
     * 保存方法
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save() {
        this.cacheService.save();
    }

    /**
     * 删除方法
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete() {
        this.cacheService.delete();
    }
}