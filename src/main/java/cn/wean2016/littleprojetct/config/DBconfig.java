package cn.wean2016.littleprojetct.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @version V1.0.0
 * @Description 配置数据源
 * @Author liuyuequn weanyq@gmail.com
 * @Date 2017/8/2 11:17
 */
@Configuration
public class DBconfig {

    @Autowired
    private Environment env;

    @Bean(name = "dataSource")
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.setInitialSize(Integer.parseInt(env.getProperty("db.initialSize")));
        dataSource.setMaxActive(Integer.parseInt(env.getProperty("db.maxActive")));

        return dataSource;
    }
}
