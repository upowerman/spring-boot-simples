package com.yunus.plugin;

import com.yunus.config.RouteDataSource;
import com.yunus.config.RouteDataSourceKeyEnum;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gaoyunfeng
 */
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "update",
                args = {MappedStatement.class, Object.class}),
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class RouteDataSourcePlugin implements Interceptor {

    private static final Integer MAPPED_STATEMENT_INDEX = 0;
    private static final Integer PARAMETER_INDEX = 1;
    private static final Integer ROW_BOUNDS_INDEX = 2;

    private static final String REGEX = ".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*";

    private static final Map<String, RouteDataSourceKeyEnum> cacheMap = new ConcurrentHashMap<>();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 判断是否有事务
        boolean synchronizationActive = TransactionSynchronizationManager.isSynchronizationActive();
        if (!synchronizationActive) {
            Object[] objects = invocation.getArgs();
            MappedStatement ms = (MappedStatement) objects[MAPPED_STATEMENT_INDEX];

            RouteDataSourceKeyEnum routeDataSourceKeyEnum = null;

            if ((routeDataSourceKeyEnum = cacheMap.get(ms.getId())) == null) {
                //读方法
                if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)) {
                    //!selectKey 为自增id查询主键(SELECT LAST_INSERT_ID() )方法，使用主库
                    if (ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
                        routeDataSourceKeyEnum = RouteDataSourceKeyEnum.MASTER;
                    } else {
                        BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[PARAMETER_INDEX]);
                        String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]", " ");
                        if (sql.matches(REGEX)) {
                            routeDataSourceKeyEnum = RouteDataSourceKeyEnum.MASTER;
                        } else {
                            routeDataSourceKeyEnum = RouteDataSourceKeyEnum.SLAVE;
                        }
                    }
                } else {
                    routeDataSourceKeyEnum = RouteDataSourceKeyEnum.MASTER;
                }
                cacheMap.put(ms.getId(), routeDataSourceKeyEnum);
            }
            RouteDataSource.setDbKey(routeDataSourceKeyEnum);
        } else {
            // 开启了事务 需要主库
            RouteDataSource.setDbKey(RouteDataSourceKeyEnum.MASTER);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
        //
    }

}
