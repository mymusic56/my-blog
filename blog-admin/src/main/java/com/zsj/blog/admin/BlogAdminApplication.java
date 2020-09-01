package com.zsj.blog.admin;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.zsj.blog.admin",
        "com.zsj.blog.common"
})
@MapperScan(basePackages = {"com.zsj.blog.common.persistence.mybatis.mapper"})
@EnableAspectJAutoProxy
public class BlogAdminApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(BlogAdminApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        generateArtifacts();
        //生成的数据好像有问题
    }

    /**
     * 通过Java code的方式使用mybatis generator
     * @throws Exception
     */
    private void generateArtifacts() throws Exception {
        List<String> warnings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(
                this.getClass().getResourceAsStream("/generatorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
