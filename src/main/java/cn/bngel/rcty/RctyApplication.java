package cn.bngel.rcty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.bngel.rcty.dao")
public class RctyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RctyApplication.class, args);
    }

}
