package com.example.its.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.its.domain.auth.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests().antMatchers("/h2-console/**").permitAll()
				.and()
				.csrf().ignoringAntMatchers("/h2-console/**")
				.and()
				.headers().frameOptions().disable();
				
		http	
				.authorizeRequests()
				// /loginは認証不要であること
				.mvcMatchers("/login/**").permitAll()
				.mvcMatchers("/signup/**").permitAll()
				.mvcMatchers("/users/**").hasAuthority("ADMIN")
				// /login以外のアクセスは認証すること
				.anyRequest().authenticated()
				.and()
				// 認証の方式はフォーム認証であること
				.formLogin()
				.usernameParameter("email")
		        .passwordParameter("password")
				// ログイページのURLは/loginであること
				.loginPage("/login");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
	        .passwordEncoder(passwordEncoder);
	}
}
