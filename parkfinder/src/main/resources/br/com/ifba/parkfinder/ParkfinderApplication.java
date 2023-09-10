/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.parkfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author j_ped
 */
@SpringBootApplication
@ComponentScan(basePackages = {"br.com.ifba.cliente.controller"})
@Configuration
public class ParkfinderApplication {
        public static void main (String [] args){
            SpringApplication.run(ParkfinderApplication.class, args);
}
    
}
