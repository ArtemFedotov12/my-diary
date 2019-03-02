package com.start.diary.config;


import com.start.diary.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
//For @PreAuthorize("hasAuthority('ADMIN')")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //Bean for form "Login". We can get user from our DB
    @Autowired
    TeacherService teacherService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //For Add Css "/templates/css/**"
                    .authorizeRequests()
                    .antMatchers( "/test","/registration","/templates/css/**","/activate/*","/lo").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/",true)
                    .permitAll()
                .and()
                    .rememberMe()
                .and()
                    .logout()
                    .logoutSuccessUrl("/login")
                    .permitAll();
    }

//For get user from DB
    //We created TeacherService implements UserDetailsService
    //Via TeacherService we get user from DB
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(teacherService)
        .passwordEncoder(passwordEncoder);
    }
}