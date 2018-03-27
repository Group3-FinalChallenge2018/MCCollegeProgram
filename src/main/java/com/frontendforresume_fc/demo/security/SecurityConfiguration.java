package com.frontendforresume_fc.demo.security;

import com.frontendforresume_fc.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private SSUserDetailsService userDetailsService;


    @Autowired
    private UserRepository userRepository;




    private static final String[] PUBLIC_MATCHERS = {
            "/register",
            "/h2-console/**",
            "/**",
            "/login",
            "/404",
            "/faqs",
            "/about_iti",
            "/applicant_resume",
            "/list_of_programs",
            "/blog",
            "/post_program"

    };

    private static final String[] USER_MATCHERS = {
            "/showhit",
            "/showhit/**",
            "/submithit",
            "/showptf",
            "/showptf/**",
            "/applicant_dashboard_applied",
            "/applicant_dashboard_accepted",
            "/applicant_dashboard_suggested",
            "/applicant_dashboard_approved",
            "/update/applicant_dashboard_approved/**"


    };

    private static final String[] ADMIN_MATCHERS = {
            "/accepted_students_hit",
            "/accepted_students_ptf",
            "/all_users",
            "/allapplicant",
            "/add_admin",
            "/approveptf/**",
            "/approvehit/**",

    };


    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception{
        return new SSUserDetailsService(userRepository);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                    .antMatchers(PUBLIC_MATCHERS).permitAll()
                    .antMatchers(USER_MATCHERS).hasAuthority("USER")
                    .antMatchers(ADMIN_MATCHERS).hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                        .and()
                    .formLogin()
                        .loginPage("/login").permitAll()
                        .and()
                    .logout()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/")
                        .and()
                    .httpBasic();
        http
                .csrf().disable();
        http
                .headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(userDetailsServiceBean());

    }
}
