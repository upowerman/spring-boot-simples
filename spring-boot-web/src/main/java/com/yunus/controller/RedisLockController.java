package com.yunus.controller;

import com.yunus.lock.RedisLock;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lanxum
 */
@RestController()
@CrossOrigin("*")
public class RedisLockController {

    /**
     * 模拟数据库中商品的数量
     */
    private int total = 100;

    @GetMapping("/product/{id}")
    public String productSell(@PathVariable("id") String id) {
        if (RedisLock.lock(id, System.currentTimeMillis() + 5000)) {
            if (total > 0) {
                total--;
                System.out.println("还剩：" + total + "件");
            }
            RedisLock.unlock(id);
            System.out.println("购买成功");
            return "success";
        } else {
            System.out.println("购买失败");
            return "retry";
        }
    }

    /**
     * 不用redis锁时 并发条件下出现脏数据
     */

    @GetMapping("/unlock/{id}")
    public String nolock(@PathVariable("id") String id) {
        // 模拟业务处理
        if (total > 0) {
            total--;
            System.out.println("还剩：" + total + "件");
        }
        return "success";
    }

    /**
     * 用java 同步锁 用ab工具测试时。时间太多没有redis 分布式锁性能高
     *
     * @param id
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/sync/{id}")
    public synchronized String syncsell(@PathVariable("id") String id) throws InterruptedException {
        // 模拟业务处理
        if (total > 0) {
            Thread.sleep(1000);
            total--;
            System.out.println("还剩：" + total + "件");
        }
        return "success";
    }

}
