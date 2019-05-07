package it.qsbl.com.config;

import it.qsbl.com.security.MyBCryptPasswordEncoder;
import it.qsbl.com.service.impl.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)//开启注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/lib/**","/temp/**","/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 所有用户均可访问的资源
                .antMatchers( "/lib/**","/temp/**","/static/**"
                        ,"/login"
                        ,"/login/login"
                        ,"/protal/registe"//跳转用户注册页面
                        ,"/protal/reg"//跳转用户注册信息提交方法
                        ,"/portal/index"
                        ,"/login/index").permitAll()
                // 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginProcessingUrl("/login/index")

                    .loginPage("/login/login").successForwardUrl("/login/success").failureForwardUrl("/login/login?error=1")
                    .failureHandler(authenticationFailureHandler)
                    .successHandler(authenticationSuccessHandler)
                .and()
                //权限拒绝的页面
                .exceptionHandling().accessDeniedPage("/403");

        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");

        http.headers().frameOptions().disable();
        http.csrf().disable();
    }


    /**
     * 设置用户密码的加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MyBCryptPasswordEncoder();

    }

    /**
     * 自定义UserDetailsService，授权
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService(){
        return new MyUserDetailsServiceImpl();
    }

    /**
     * AuthenticationManager
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    public static void main(String[] args){
        String password = new BCryptPasswordEncoder().encode("123456");
        System.out.println(password);
    }
}
