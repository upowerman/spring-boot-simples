package com.yunus.users.mapper;

import com.yunus.users.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Luke
 * @since 2020-07-17
 */
public interface UserMapper extends BaseMapper<User> {


    /**
     * 全量更新
     *
     * @param id
     */
    @Update("update user set  where id = #{id}")
    void updateById(@Param("id") Integer id);
}
