package org.edominguez.web.spring.rest.demo;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class SecurityPolicyConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

	    auth.inMemoryAuthentication()
	      	.withUser("devOps").password("devOps1234").roles("Apps")
	      	.and()
	      	.withUser("testers").password("testers1234").roles("Testers");
	  }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/users").hasAnyRole("Apps","Testers")
			 .antMatchers(
                     "/v2/api-docs",
                      "/swagger-resources", 
                     "/swagger-resources/configuration/ui", 
                     "/swagger-resources/configuration/security")
			 .permitAll();
	}
	
/*	@Bean
	public UserDetailsService userDetailsService(){
		GrantedAuthority authority = new SimpleGrantedAuthority("USER_GRP");
		UserDetails userDetails = (UserDetails)new User("user", "user1234", (Collection<? extends GrantedAuthority>) Arrays.asList(authority));
		return new InMemoryUserDetailsManager(Arrays.asList(userDetails));
	}*/
	
	
	@Bean
	public UserDetailsService userDetailsService() {
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	    manager.createUser(User.withUsername("user").password("user1234").roles("Apps","Testers").build());
	    return manager;
	}
	

}
