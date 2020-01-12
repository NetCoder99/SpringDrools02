package com.home.SpringDrools02.dbconfig;

import javax.sql.DataSource;

//import org.hibernate.cfg.Environment;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DepartmentDbConfig {

    @Autowired
    private Environment env;
    
    
	@Bean
    @Primary
    public DataSource getDataSource() {
		
		String url = env.getProperty("spring.oracle.url");
		
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
        //dataSourceBuilder.url("jdbc:oracle:thin:@192.168.0.19:1521:orcl1");
        dataSourceBuilder.url(url);
        dataSourceBuilder.username("system");
        dataSourceBuilder.password("John$0001");
        return dataSourceBuilder.build();
    }
    
//    @Bean
//    @Primary
//    public DataSource DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public DataSourceProperties DepartmentDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//    
}
