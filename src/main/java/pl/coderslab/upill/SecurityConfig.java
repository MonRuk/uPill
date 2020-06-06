package pl.coderslab.upill;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.coderslab.upill.service.SpringDataUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   /* @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService()).passwordEncoder(passwordEncoder());
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/uPill/about").permitAll()
                .antMatchers("/uPill/user").authenticated()
                .and().formLogin()
                .loginPage("/uPill/login")
                .failureUrl("/uPill/login/error")
                .defaultSuccessUrl("/uPill/user")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutSuccessUrl("/uPill/loggedout")
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/uPill/403");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }
}
