package com.oe.edu.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.oe.edu.OEEncode;
import com.oe.edu.dao.user.UserRepository;

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private customerUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(getPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("**/test/**")
			.authenticated()
			.anyRequest().permitAll()
			.and()
			.formLogin().permitAll();
		
		http.csrf().disable();
	}
	
	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String codepassword_ = OEEncode.removeOEEncodedPassword(encodedPassword);
				return passwordEncoder.matches(rawPassword, codepassword_);
			}
			
			@Override
			public String encode(CharSequence rawPassword) {
				return oeEncode(rawPassword);
			}
		};
	}
	
	private String oeEncode(CharSequence rawPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		

//		String s1 = "test1password";
//		String s2 = "test2password";
//		String c1 = passwordEncoder.encode(s1);
//		String c2 = passwordEncoder.encode(s2);
//		String cc1 = OEEncode.getOEEncodedPassword(c1);
//		String cc2 = OEEncode.getOEEncodedPassword(c2);
//		String cd1 = OEEncode.removeOEEncodedPassword(cc1);
//		String cd2 = OEEncode.removeOEEncodedPassword(cc2);
		
//		System.out.println(s1);
//		System.out.println(c1);
//		System.out.println(cc1);
//		System.out.println(cd1);
//
//		System.out.println(s2);
//		System.out.println(c2);
//		System.out.println(cc2);
//		System.out.println(cd2);
		
		
		
		return OEEncode.getOEEncodedPassword(passwordEncoder.encode(rawPassword));
	}
	
}
