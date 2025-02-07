package com.bca.cmt;
import org.apache.tomcat.util.net.ServletConnectionImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CmtApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(CmtApplication.class, args);
	}
}
