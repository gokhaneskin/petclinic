package com.gokhaneskin.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(value =PetClinicProperties.class )
//@ServletComponentScan
public class PetClinicApp {
    public static void main(String[] args){
        SpringApplication.run(PetClinicApp.class,args);
    }
}
