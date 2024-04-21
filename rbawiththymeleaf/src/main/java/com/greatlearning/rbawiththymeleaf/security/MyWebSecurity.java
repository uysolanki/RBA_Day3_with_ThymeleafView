package com.greatlearning.rbawiththymeleaf.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.greatlearning.rbawiththymeleaf.service.FetchPrincipalFromDb;

@Configuration
@EnableWebSecurity
public class MyWebSecurity //extends WebSecurityConfigurerAdapter
{

//	@Override  //Authentication
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(myGlAuthPro());
//		
//	}
	
	@Bean
	public DaoAuthenticationProvider myGlAuthPro() {
		DaoAuthenticationProvider dap=new DaoAuthenticationProvider();
		dap.setUserDetailsService(myGlUserDetails());
		dap.setPasswordEncoder(myGlPassEnc());
		
		return dap;
	}

	@Bean
	public PasswordEncoder myGlPassEnc() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService myGlUserDetails() //Decorated UserDetails
	{
		return new FetchPrincipalFromDb();
	}


//	@Override //Authorisation
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//        .antMatchers("/","/employees","/employees/new","/403").hasAnyAuthority("USER","ADMIN")
//        .antMatchers("/employees/edit/**","/employees/**").hasAuthority("ADMIN")
//        .anyRequest().authenticated()
//        .and()
//        .formLogin().loginProcessingUrl("/login").successForwardUrl("/employees").permitAll()
//        .and()
//        .logout().logoutSuccessUrl("/login").permitAll()
//        .and()
//        .exceptionHandling().accessDeniedPage("/403")
//        .and()
//        .cors().and().csrf().disable();
//
//	}
	
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	    {
		http.authorizeRequests()
       .antMatchers("/","/employees","/employees/new","/403").hasAnyAuthority("USER","ADMIN")
       .antMatchers("/employees/edit/**","/employees/**").hasAuthority("ADMIN")
       .anyRequest().authenticated()
       .and()
       .formLogin().loginProcessingUrl("/login").successForwardUrl("/employees").permitAll()
       .and()
       .logout().logoutSuccessUrl("/login").permitAll()
       .and()
       .exceptionHandling().accessDeniedPage("/403")
       .and()
       .cors().and().csrf().disable();
		
		http.authenticationProvider(myGlAuthPro());
		
		return http.build();
	    }    
}
