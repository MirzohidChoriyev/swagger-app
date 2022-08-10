package com.example.swaggerapp.config;

import com.example.swaggerapp.security.JwtConfigurer;
import com.example.swaggerapp.security.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final JwtTokenProvider jwtTokenProvider;

    public SecurityConfiguration(@Lazy UserDetailsService userDetailsService, JwtTokenProvider jwtTokenProvider) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers("/api/employee/save").permitAll()
                .antMatchers("/api/utils/session_time").permitAll()
                .antMatchers("/api/notification/getAll").permitAll()
                .antMatchers("/api/notification/save").permitAll()
                .antMatchers("/api/notification/delete/*").permitAll()
                .antMatchers("/api/notification/getById/*").permitAll()
                .antMatchers("/api/notification/edit/*").permitAll()
                .antMatchers("/api/shop/save").permitAll()
                .antMatchers("/api/shop/all").permitAll()
                .antMatchers("/api/workplace/save").permitAll()
                .antMatchers("/api/supplier/save").permitAll()
                .antMatchers("/api/reject/save").permitAll()
                .antMatchers("/api/report/save").permitAll()
                .antMatchers("/api/bonus/save").permitAll()
                .antMatchers("/api/webhook").permitAll()
                .antMatchers("/api/paytype/save").permitAll()
                .antMatchers("/api/product/save").permitAll()
                .antMatchers("/api/product/all").permitAll()
                .antMatchers("/api/product/needall").permitAll()
                .antMatchers("/api/customer/save").permitAll()
                .antMatchers("/api/category/save").permitAll()
                .antMatchers("/api/paystatus/save").permitAll()
                .antMatchers("/api/sale/save").permitAll()
                .antMatchers("/api/warehouse/save").permitAll()
                .antMatchers("/api/productwithamount/save").permitAll()
                .antMatchers("/api/transfer/save").permitAll()
                .antMatchers("/api/menu/save").permitAll()
                .antMatchers("/api/news/save").permitAll()
                .antMatchers("/api/news/delete/*").permitAll()
                .antMatchers("/api/comment/save").permitAll()
                .antMatchers("/api/comment/newsIdAll/*").permitAll()
                .antMatchers("/api/menu/all").permitAll()
                .antMatchers("/api/news/all").permitAll()
                .antMatchers("/api/news/getById/*").permitAll()
                .antMatchers("/api/comment/getById/*").permitAll()
                .antMatchers("/api/product/getById/*").permitAll()
                .antMatchers("/api/product/delete/*").permitAll()
                .antMatchers("/api/product/updateNoteChar").permitAll()
                .antMatchers("/api/news/edit/*").permitAll()
                .antMatchers("/api/product/edit/*").permitAll()
                .antMatchers("/api/comment/edit/*").permitAll()
                .antMatchers("/api/news/edit_seen/*").permitAll()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/api/employee/all").permitAll()
                .antMatchers("/api/category/all").permitAll()
                .antMatchers("/api/users/register").permitAll()
                .antMatchers("/api/users/edit/*").permitAll()
                .antMatchers("/api/users/delete/*").permitAll()
                .antMatchers("/api/users/getById/*").permitAll()
                .antMatchers("/api/users/getByUsername/*").permitAll()
                .antMatchers("/api/users/getByUser/*").permitAll()
                .antMatchers("/api/users/existByUsername/*").permitAll()
                .antMatchers("/api/users/loginEdit/*").permitAll()
                .antMatchers("/api/test/get").permitAll()
                .antMatchers("/api/role/save").permitAll()
                .antMatchers("/api/salaries/save").permitAll()
                .antMatchers("/api/month/add").permitAll()
                .antMatchers("/api/salaries/getsalary/*").permitAll()
                .antMatchers("/api/users/getByUserCount").permitAll()
                .antMatchers("/api/users/getUsers").permitAll()
                .antMatchers("/api/product/getByProductsCount").permitAll()
                .antMatchers("/api/userImage/save/*").permitAll()
                .antMatchers("/api/userImage/readImage/*").permitAll()
                .antMatchers("/api/userImage/readImageHashId/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}


