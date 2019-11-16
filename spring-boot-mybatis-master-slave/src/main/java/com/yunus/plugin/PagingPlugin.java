package com.yunus.plugin;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Properties;

/**
 * 自定义分页插件
 *
 * @author gaoyunfeng
 */
@Intercepts({
        @Signature(
                type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class}
        )
})
public class PagingPlugin implements Interceptor {

    private final static String REGEX = "^\\s*[Ss][Ee][Ll][Ee][Cc][Tt].*$";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        // BoundSql类中有一个sql属性，即为待执行的sql语句
        BoundSql boundSql = handler.getBoundSql();
        String sql = boundSql.getSql();
        if (sql.matches(REGEX)) {
            // delegate是RoutingStatementHandler通过mapper映射文件中设置的statementType来指定具体的StatementHandler
            Object delegate = getFieldValue(handler, "delegate");
            // rowBounds,即为Mybais 原生的Sql 分页参数,由于Rowbounds 在BaseStateHandler中所以我们需要去找父类
            RowBounds rowBounds = (RowBounds) getFieldValue(delegate, "rowBounds");
            // 如果rowBound不为空，且rowBounds的起始位置不为0，则代表我们需要进行分页处理
            if (rowBounds != null) {
                // assemSql(...)完成对sql语句的装配及rowBounds的重置操作
                setFieldValue(boundSql, "sql", assemSql(sql, rowBounds));
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String prop1 = properties.getProperty("prop1");
        String prop2 = properties.getProperty("prop2");
        System.out.println(prop1 + "------" + prop2);
    }

    private Object getFieldValue(Object object, String fieldName) {
        Field field = null;
        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                if (field != null) {
                    field.setAccessible(true);
                    break;
                }

            } catch (NoSuchFieldException e) {
                //这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
            }
        }
        try {
            return field.get(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setFieldValue(Object object, String fieldName, Object value) {
        Field field = null;
        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                if (field != null) {
                    field.setAccessible(true);
                    try {
                        field.set(object, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }

            } catch (NoSuchFieldException e) {
                //这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
            }
        }
    }

    public String assemSql(String oldSql, RowBounds rowBounds) throws Exception {
        String sql = oldSql + " limit " + rowBounds.getOffset() + "," + rowBounds.getLimit();
        // 这两步是必须的，因为在前面置换好sql语句以后，实际的结果集就是我们想要的所以offset和limit必须重置为初始值
        setFieldValue(rowBounds, "offset", RowBounds.NO_ROW_OFFSET);
        setFieldValue(rowBounds, "limit", RowBounds.NO_ROW_LIMIT);
        return sql;
    }
}
