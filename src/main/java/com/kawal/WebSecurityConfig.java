package com.kawal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import com.kawal.service.AppUserDetailsService;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home").permitAll()
                .anyRequest().authenticated();
        http
                .formLogin()
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
        .and()
        .authorizeRequests().anyRequest().authenticated();
        http
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        auth.userDetailsService(appUserDetailsService).passwordEncoder(md5PasswordEncoder);
    }

}
