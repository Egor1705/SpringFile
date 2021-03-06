package by.bsu.app;

import java.io.File;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import by.bsu.app.controller.FileUploadController;

@Configuration
@SpringBootApplication
@EnableWebMvc
@EnableJpaRepositories(basePackages = "by.bsu.app.repo")
@ComponentScan({"by.bsu.app","by.bsu.app.controller"})
public class App  {
    public static void main(String[] args) {
    	
    	
    	new File(FileUploadController.uploadDir).mkdir();
    	new File(FileUploadController.taskDir).mkdir();
        SpringApplication.run(App.class, args);
    } 
    
   
   
	    }
    

