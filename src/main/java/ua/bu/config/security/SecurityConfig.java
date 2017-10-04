package ua.bu.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "ua.bu.config")
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource dataSource;


    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                //   .inMemoryAuthentication()
                //   .withUser("user").password("password").roles("USER").and()
                //   .withUser("admin").password("password").roles("USER", "ADMIN");
                .usersByUsernameQuery("SELECT loginName, password, active FROM user WHERE loginName = ?")
                .authoritiesByUsernameQuery("SELECT loginName, role FROM roles WHERE loginName = ?")
                // .rolePrefix("")
                .dataSource(dataSource);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").authenticated()
                .antMatchers("/users/**").access("hasRole('ADMIN')")
                .antMatchers("/issue/newIssue").access("hasRole('ADMIN')")
                .antMatchers("/report/**").access("hasAnyRole('ADMIN','TRADER')")
                // .antMatchers("/qouteRetrieval/**").access("hasRole('TRADER')")
                //.antMatchers("/quote/addNewQuote").access("hasRole('TRADER')")
                .antMatchers("/asset").access("hasAnyRole('TRADER','ADMIN' , 'BOOKKEEPER')")
                .and().formLogin()
                .loginPage("/loginPage").permitAll()//.failureUrl("/error_page")
                .usernameParameter("loginName")
                .passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and().exceptionHandling().accessDeniedPage("/error_page");

    }
}
