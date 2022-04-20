package com.drs.mes.DBconfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.drs.mes.mapper.mesBase",sqlSessionTemplateRef ="mesBaseSqlSessionTemplate")
public class MesBaseDataSourceConfig {


    @Value("${spring.datasource.mesBase.url}")
    private String url;
    @Value("${spring.datasource.mesBase.username}")
    private String username;
    @Value("${spring.datasource.mesBase.password}")
    private String password;
    @Value("${spring.datasource.mesBase.driverClassName}")
    private String driverClassName;
    /**本数据源扫描的mapper路径*/
    static final String MAPPER_LOCATION = "classpath:mapping/mesBase/*.xml";


    /**创建数据源*/
    @Bean(name = "mesBaseDS")
    @Primary
    public DataSource getmesBaseDataSource() {
        DataSource build =  DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .build();
        return build;
    }


    /**创建SessionFactory*/
    @Bean(name = "mesBaseSqlSessionFactory")
    @Primary
    public SqlSessionFactory mesBaseSqlSessionFactory(@Qualifier("mesBaseDS") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //设置mapper配置文件
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return bean.getObject();
    }

    /**创建事务管理器*/
    @Bean("mesBaseTransactionManger")
    @Primary
    public DataSourceTransactionManager mesBaseTransactionManger(@Qualifier("mesBaseDS") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**创建SqlSessionTemplate*/
    @Bean(name = "mesBaseSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate mesBaseSqlSessionTemplate(@Qualifier("mesBaseSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
