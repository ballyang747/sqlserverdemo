package org.fkjava.mybatis1sb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描org.fkjava.mybatis1sb.mapper下面所有MyBatis接口，
// 创建对象，并设置成Spring的bean(按照规范，bean名称为接口名第一个字母小写)
@MapperScan("org.fkjava.mybatis1sb.mapper")
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
