package com.yunus.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: gaoyunfeng
 * @date: 2018/11/29
 */
@Component
public class ZsetFoo {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void zadd(String key, Object value, double score) {
        redisTemplate.opsForZSet().add(key, value, score);
    }

    public void zadd(String key, Set<ZSetOperations.TypedTuple<Object>> tuples) {
        redisTemplate.opsForZSet().add(key, tuples);
    }

    public void remove(String key, Object... values) {
        redisTemplate.opsForZSet().remove(key, values);
    }

    public void incrementScore(String key, Object value, double delta) {
        //原为1.1
        redisTemplate.opsForZSet().incrementScore(key, value, delta);
    }

    public void rank(String key, Object o) {
        System.out.println(redisTemplate.opsForZSet().rank(key, o));
    }

    public void reverseRank(String key, Object o) {
        System.out.println(redisTemplate.opsForZSet().reverseRank(key, o));
    }

    public void range(String key, long start, long end) {
        System.out.println(redisTemplate.opsForZSet().range(key, start, end));
    }

    public void rangeWithScores(String key, long start, long end) {
        Set<ZSetOperations.TypedTuple<Object>> tuples = redisTemplate.opsForZSet().rangeWithScores(key, start, end);
        Iterator<ZSetOperations.TypedTuple<Object>> iterator = tuples.iterator();
        while (iterator.hasNext()) {
            ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();
            System.out.println("value=" + typedTuple.getValue() + "\tscore=" + typedTuple.getScore());
        }
    }

    public void rangeByScoreWithScores(String key, double min, double max) {
        Set<ZSetOperations.TypedTuple<Object>> tuples = redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max);
        Iterator<ZSetOperations.TypedTuple<Object>> iterator = tuples.iterator();
        while (iterator.hasNext()) {
            ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();
            System.out.println("value=" + typedTuple.getValue() + "\tscore=" + typedTuple.getScore());
        }
    }

    public void rangeByScore(String key, double min, double max, long offset, long count) {
        System.out.println(redisTemplate.opsForZSet().rangeByScore(key, min, max, offset, count));
    }
}
