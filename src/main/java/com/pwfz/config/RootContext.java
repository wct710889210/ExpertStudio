package com.pwfz.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("com.pwfz.repository")
@ImportResource("classpath:spring/RootContext.xml")
@EnableJpaRepositories("com.pwfz.repository")
public class RootContext {

    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost/j2ee_design?useSSL=false&serverTimezone=Asia/Shanghai");
        dataSource.setUser("root");
        dataSource.setPassword("wct123456");
        return dataSource;
    }

    @Bean
    public HibernateJpaVendorAdapter vendorAdapter(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setShowSql(true);
        return vendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter());
        entityManagerFactory.setPackagesToScan("com.pwfz.entity");
        return entityManagerFactory;
    }

}
