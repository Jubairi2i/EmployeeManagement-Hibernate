package com.i2i.config;

import javax.sql.DataSource;

import com.i2i.Controller.EmployeeController;
import com.i2i.dao.IEmployeeDao;
import com.i2i.dao.impl.EmployeeDaoImpl;
import com.i2i.entity.Employee;
import com.i2i.entity.Trainee;
import com.i2i.entity.Trainer;
import com.i2i.service.IEmployeeService;
import com.i2i.service.impl.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.i2i"})
@EnableWebMvc
public class EmployeeConfig<T extends Employee> {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Demo");
        dataSource.setUsername("root");
        dataSource.setPassword("Jubair@1999");
        return dataSource;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.show_sql","true");
        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
        hibernateProperties.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
        return hibernateProperties;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.i2i");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
}
