package com.serverone.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Create By CJH on 2018/5/25
 */
@Configuration
public class SqlSessionFactoryConfig {

    @Value("${mybatis.mapper-locations}")
    private String mapperPath;
    @Value("${mybatis.config-locations}")
    private String mybatisConfigPath;
    @Value("${mybatis.type-aliases-package}")
    private String entityPackage;

    @Autowired
    private DataSource dataSource;

    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFacory () throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        String mapperLocations = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
//        String configLocation = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mybatisConfigPath;
        sqlSessionFactoryBean.setConfigLocation(resolver.getResources(mybatisConfigPath)[0]);
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperPath));
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }
}