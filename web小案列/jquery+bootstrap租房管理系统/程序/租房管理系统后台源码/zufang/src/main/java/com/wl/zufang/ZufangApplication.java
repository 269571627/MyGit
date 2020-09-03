package com.wl.zufang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wl.zufang.dao")
public class ZufangApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZufangApplication.class, args);
    }

}
