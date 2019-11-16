package com.yunus.mapper;

import com.yunus.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author gaoyunfeng
 */
@Mapper
public interface UserMapper {
    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User getOneById(Long id);

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @Insert("insert into user(name,age,address,male) values(#{name},#{age},#{address},#{male})")
    boolean save(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @Update("update user set name=#{name},age=#{age},address=#{address},male=#{male} where id=#{id}")
    boolean update(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Delete("delete from user where id=#{id}")
    boolean delete(long id);

    /**
     * 根据ids 获取用户
     *
     * @param ids       id逗号分隔
     * @param rowBounds 分页
     * @return
     */
    @SelectProvider(value = UserProvider.class, method = "list")
    @Results({
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    List<User> list(@Param("ids") String ids, RowBounds rowBounds);

    /**
     * 内部类 生成 sql
     */
    class UserProvider {

        public String list(String ids) {
            return new SQL() {{
                SELECT("*");
                FROM("user");
                if (ids != null && ids.length() > 0) {
                    WHERE("id in(" + ids + ")");
                }
            }}.toString();
        }
    }


}
