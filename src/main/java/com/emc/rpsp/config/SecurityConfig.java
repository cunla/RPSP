package com.emc.rpsp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	
//        http.csrf().disable()
//        .authorizeRequests()
//         .anyRequest().permitAll();
//    }

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http.csrf().disable()
        .authorizeRequests()
         .antMatchers("/login/*").permitAll()
         .anyRequest().fullyAuthenticated();
        
         http.formLogin()
         .loginPage("/login/login-form.html")
         .failureUrl("/login/login-form.html")
         .loginProcessingUrl("/login-action")
         .failureHandler(
                 (request, response, authentication) -> {
                     response.setStatus(HttpStatus.UNAUTHORIZED.value());
                 })

         .permitAll()
         .and()
         .httpBasic();
         
         http.logout()
         .logoutUrl("/logout-action")
         .logoutSuccessUrl("/login/login-form.html")
         .permitAll();       

    }
    
    

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}