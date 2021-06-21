
package com.wadi.security;

import org.checkerframework.checker.guieffect.qual.AlwaysSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		
		.csrf().disable()
		.authorizeRequests()
		        .antMatchers(HttpMethod.GET,"/springSecurity").permitAll()
				.antMatchers(HttpMethod.GET,"/springSecurity/api/v1/students/**").hasRole(ApplicationUserRole.STUDENT.name())
				.anyRequest()
				.authenticated()
				.and()
				//.httpBasic()
				
				.formLogin().loginPage("/login").permitAll()
				.defaultSuccessUrl("/courses",true);
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {

		UserDetails annaUser = User.builder().username("ahmed").password(passwordEncoder.encode("1234567"))
				.roles(ApplicationUserRole.STUDENT.name()).build();

		UserDetails linderUser = User.builder().username("wadi").password(passwordEncoder.encode("12345678"))
				.roles(ApplicationUserRole.ADMIN.name()).build();
		
		UserDetails mjtaba = User.builder()
				.username("mjtaba").password(passwordEncoder.encode("12345678"))
				.roles(ApplicationUserRole.ADMINTRANEE.name()).build();

		return new InMemoryUserDetailsManager(annaUser, linderUser,mjtaba);
	}

}
