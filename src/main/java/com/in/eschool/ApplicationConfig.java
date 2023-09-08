package com.in.eschool;
import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler; 
@Configuration 
@EnableWebSecurity
public class ApplicationConfig extends WebSecurityConfigurerAdapter { 
	 	@Autowired
	    private DataSource dataSource;
	 	
	 	@Autowired
	 	private SecurityUserDetailsService securityUserDetailsService;
	     
	    @Bean
	    public SecurityUserDetailsService userDetailsService() {
	        return new SecurityUserDetailsService();
	    }
	     
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	     
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	    }
	 
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }
	 
	    @Override 
	    protected void configure(HttpSecurity http) throws Exception { 
	       http
	       .csrf().disable()
	       .authorizeRequests().antMatchers("/register**")
	       .permitAll() .anyRequest().authenticated() 
	       .and() 
	       .formLogin() .loginPage("/login")
	       .permitAll() 
	       .successHandler(new AuthenticationSuccessHandler() {
	    	   
               @Override
               public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                       Authentication authentication) throws IOException, ServletException {
                   // run custom logics upon successful login
            	   System.out.println("authentication.getName()"+authentication.getName());
            	   request.getSession().setAttribute("username",authentication.getName());
               }
           })
	       .and() 
	       .logout() .invalidateHttpSession(true) 
	       .clearAuthentication(true) .permitAll();
	    }
	    
   
   
}