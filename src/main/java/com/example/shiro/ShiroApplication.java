package com.example.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShiroApplication {

    public static void main(String[] args) {
        Object result = new SimpleHash("MD5", "123456", "123shiro", 2);
        System.err.println(result);
        SpringApplication.run(ShiroApplication.class, args);
    }
}
