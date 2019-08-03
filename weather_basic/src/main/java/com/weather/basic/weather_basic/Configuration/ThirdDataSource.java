//package com.weather.basic.weather_basic.Configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//import javax.sql.DataSource;
//
///**
// * 若使用spring不支持的第三方数据源
// * 需要自己将数据源注入到spring容器中
// */
//@Configuration
//@ConfigurationProperties(prefix = "spring.datasource")
//public class ThirdDataSource {
//    private String url;
//    private String username;
//    private String password;
//    public DataSource getDataSource(){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);// 用户名
//        dataSource.setPassword(password);// 密码
//        return dataSource;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//}
