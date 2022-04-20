//package com.drs.mes.DBconfig;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = "com.drs.mes.mapper.drsops", sqlSessionFactoryRef = "secondSqlSessionFactory")
//public class SecondDataSourceConfig {
//
//    @Bean("secondDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.second")
//    public DataSource getDb1DataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean("secondSqlSessionFactory")
//    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("secondDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/drsops/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean("secondSqlSessionTemplate")
//    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
