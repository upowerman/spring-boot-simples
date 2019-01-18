package com.yunus.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: gaoyunfeng
 * @date: 2018/11/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZsetFooTest {

    @Autowired
    private ZsetFoo zsetFoo;

    @Test
    public void zadd() {
        zsetFoo.zadd("myzset", "zhangsan", 1);
    }

    @Test
    public void zadd2() {
        ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-5", 9.6);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-6", 9.9);
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        zsetFoo.zadd("myzset", tuples);
    }

    @Test
    public void remove() {
        zsetFoo.remove("myzset", "zset-5");
    }

    @Test
    public void incrementScore() {
        zsetFoo.incrementScore("myzset", "zset-6", 1.1);
    }

    @Test
    public void rank() {
        zsetFoo.rank("myzset", "zset-6");
    }

    @Test
    public void reverseRank() {
        zsetFoo.reverseRank("myzset", "zset-6");
    }

    @Test
    public void range() {
        zsetFoo.range("myzset", 0, -1);
    }

    @Test
    public void rangeWithScore() {
        zsetFoo.rangeWithScores("myzset", 0, -1);
    }

    @Test
    public void rangeByScoreWithScores() {
        zsetFoo.rangeByScoreWithScores("myzset", 0, 12);
    }

    @Test
    public void rangeByScore() {
        zsetFoo.rangeByScore("myzset", 10, 15, 1, 1);
    }
}
