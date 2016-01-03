package com.emc.rpsp.config;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.emc.rpsp.config.auditing.AuditConsts;
import com.emc.rpsp.config.auditing.AuditEntry;
import com.emc.rpsp.config.auditing.AuditTypesHandler;
import com.emc.rpsp.infra.common.auth.domain.CurrentUser;

@Configuration @EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER) class SecurityConfig
extends WebSecurityConfigurerAdapter {

    @Autowired 
    private UserDetailsService userDetailsService;

    @Autowired 
    private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
    
    @Autowired
    private AuditTypesHandler auditTypesHandler;


    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //
    // http.csrf().disable()
    // .authorizeRequests()
    // .anyRequest().permitAll();
    // }
    
    
    @Override protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests().antMatchers("/app/login/*").permitAll()

        .antMatchers("/assets/js/*").permitAll().antMatchers("/assets/js/*/*/*").permitAll()
        .antMatchers("/assets/css/*").permitAll().antMatchers("/assets/css/*/*/*").permitAll()
        .antMatchers("/assets/images/*").permitAll()

        .antMatchers("/custom/js/*").permitAll().antMatchers("/custom/css/*").permitAll()
        .antMatchers("/custom/images/*").permitAll()

        .antMatchers("/locale").permitAll().antMatchers("/locales/*").permitAll()
        .antMatchers("/app/locale/*").permitAll().anyRequest().fullyAuthenticated();

        http.formLogin().loginPage("/app/login/login-form.html")
        .failureUrl("/app/login/login-form.html").loginProcessingUrl("/login-action")
        .failureHandler((request, response, authentication) -> {
        	logAuditData(null, request, authentication, AuditConsts.LOGIN_ACTION, AuditConsts.LOGIN_LOGOUT_FAILURE_RESULT);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }).successHandler(authenticationSuccessHandler).successHandler((request, response, authentication) -> {
        	logAuditData(authentication, null, null, AuditConsts.LOGIN_ACTION, AuditConsts.LOGIN_LOGOUT_SUCCESS_RESULT);
        })
        .permitAll().and().httpBasic();

        http.logout().logoutUrl("/logout-action")
        .logoutSuccessHandler((request, response, authentication) -> {
        	logAuditData(authentication, null, null, AuditConsts.LOGOUT_ACTION, AuditConsts.LOGIN_LOGOUT_SUCCESS_RESULT);
            response.sendRedirect("rpsp/app/login/login-form.html");
        })
        
        .permitAll();

    }


    @Override public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    
    
    private void logAuditData(Authentication authentication, HttpServletRequest httpServletRequest, 
    		                            AuthenticationException authenticationException,String action, String res){
    	AuditEntry auditEntry = null;
    	if(res.equals(AuditConsts.LOGIN_LOGOUT_SUCCESS_RESULT)){
    		 String login = "";
	   		 String accountName = "";
	   		 String userName = "";
	   		 
	   		 if(authentication != null){
	    		 CurrentUser currentUser = (CurrentUser)authentication.getPrincipal();
	    		 login = currentUser.getUser().getLogin();
	    		 if(currentUser.getAccount() != null){
		   			 accountName = currentUser.getAccount().getLabel();
		   			 userName = currentUser.getUser().getFullName();
		   		 }
	    		 else{
	    			 accountName = "system";
		   			 userName = "admin";
	    		 }
	   		 }
             auditEntry = new AuditEntry(new Date(), login, action, "User: " + userName, res, "Account: " + accountName);           
    	}
    	else{
    		auditEntry = new AuditEntry(new Date(), httpServletRequest.getParameter("username"), action, "", res, authenticationException.getLocalizedMessage());
            
    	}
    	auditTypesHandler.writeRecordToAudit(auditEntry);
    }
	

}
