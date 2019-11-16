package com.yunus.config;

import com.yunus.plugin.RouteDataSourcePlugin;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoyunfeng
 */
@Configuration
@EnableTransactionManagement
public class MybatisConfig {

    /**
     * master 数据源
     *
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * slave 数据源
     *
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源
     *
     * @return
     */
    @Bean
    public RouteDataSource routeDataSource() {
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put(RouteDataSourceKeyEnum.MASTER.name(), masterDataSource());
        dataSourceMap.put(RouteDataSourceKeyEnum.SLAVE.name(), slaveDataSource());
        RouteDataSource routeDataSource = new RouteDataSource();
        routeDataSource.setTargetDataSources(dataSourceMap);
        routeDataSource.setDefaultTargetDataSource(masterDataSource());
        return routeDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(RouteDataSource routeDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(routeDataSource);
        sqlSessionFactoryBean.setPlugins(new RouteDataSourcePlugin());
        return sqlSessionFactoryBean.getObject();
    }

}
