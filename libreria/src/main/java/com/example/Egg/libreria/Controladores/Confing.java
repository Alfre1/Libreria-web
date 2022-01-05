
package com.example.Egg.libreria.Controladores;

import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @author Alfredo
 */
@Configuration
public class Confing {
      @Bean
    public ErrorPageRegistrar errorPageRegistrar(){
        return new Error();
    
    
    
    
    }
}