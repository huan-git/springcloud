package com.ahuan.quartz.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author huan
 * @date 2019/03/27
 */
@Configuration
@MapperScan(basePackages = {"com.example.quartz.mapper"}, sqlSessionTemplateRef = "apiSqlSessionTemplate")
public class APIDataSourceConfig {

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource getDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "apiSqlSessionFactory")
    @Primary
    public SqlSessionFactory rdsSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        sqlSessionFactory
                .setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml"));
        return sqlSessionFactory.getObject();
    }

    @Bean(name = "apiTransactionManager")
    @Primary
    public DataSourceTransactionManager rdsTransactionManager(@Qualifier("dataSource") DataSource rdsDataSource) {
        return new DataSourceTransactionManager(rdsDataSource);
    }

    @Bean(name = "apiSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate
    rdsSqlSessionTemplate(@Qualifier("apiSqlSessionFactory") SqlSessionFactory rdsSqlSessionFactory) {
        return new SqlSessionTemplate(rdsSqlSessionFactory);
    }

    @Bean(name = "apiNamedParameterJdbcTemplate")
    @Primary
    public NamedParameterJdbcTemplate rdsNamedParameterJdbcTemplate(@Qualifier("dataSource") DataSource rdsDataSource) {
        return new NamedParameterJdbcTemplate(rdsDataSource);
    }
}
