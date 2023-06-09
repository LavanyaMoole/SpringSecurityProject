package com.perscholas.security.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.http.HttpSession;

@Configuration
@Order(1)
public class AdminSecurityConfig {

    @Autowired
    public CustomUserDetailsService customUserDetailsService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
@Bean
public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests().antMatchers("/").permitAll();
    http.antMatcher("/admin/**").authorizeHttpRequests().anyRequest().hasAuthority("ADMIN")
            .and().formLogin()
            .loginPage("/admin/login")
            .usernameParameter("email")
            .loginProcessingUrl("/admin/login")
            .defaultSuccessUrl("/admin/home").permitAll();

    return http.build();

}
}
