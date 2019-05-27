package com.gokhaneskin.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value =PetClinicProperties.class )
public class PetClinicApp {
    public static void main(String[] args){
        SpringApplication.run(PetClinicApp.class,args);
    }
}
