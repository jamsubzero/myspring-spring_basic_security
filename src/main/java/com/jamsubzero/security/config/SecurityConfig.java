package com.jamsubzero.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
         .csrf().disable()
         .authorizeRequests().anyRequest().authenticated()
         .and()
         .httpBasic();
    }
  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
    	
       auth.inMemoryAuthentication() 
          .withUser(getUserDetails());
   
    }
    
    @Bean
    private UserDetails getUserDetails() {
    	PasswordEncoder encoder = PasswordEncoderFactories
    		     .createDelegatingPasswordEncoder();
    	
    	UserDetails user = User
    			.withUsername("jam")
    		    .password(encoder.encode("jampass"))
    		    .roles("USER").build();
    	return user;
    }
    
}