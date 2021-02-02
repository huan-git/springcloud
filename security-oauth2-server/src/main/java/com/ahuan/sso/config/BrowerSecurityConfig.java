package com.ahuan.sso.config;

import com.ahuan.sso.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityAuthenticationProvider provider;

    @Qualifier("mySecurityContextLogoutHandler")
    @Autowired
    private LogoutHandler mySecurityContextLogoutHandler;

    /**
     * 如若需从数据库动态判断权限则实现 AccessDecisionManager
     * 
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.antMatcher("/**").authorizeRequests()
            // 设置不拦截路径
            .antMatchers("/login", "/oauth/authorize**").permitAll().anyRequest().authenticated()

            // 设置登录
            .and().formLogin().loginPage("/login").failureUrl("/login?error=true").permitAll()

            // 设置登出自定义登出处理
            .and().logout().invalidateHttpSession(true).clearAuthentication(true).logoutUrl("/logout")
            .addLogoutHandler(mySecurityContextLogoutHandler).and()

            // 配置没有权限的自定义处理类； 处理异常，拒绝访问就重定向到 403 页面
            .exceptionHandling().accessDeniedPage("/403"); 

        // 设置跨域问题
        http.cors().and().csrf().disable();
        http.sessionManagement().invalidSessionUrl("/login");
        // 单用户登录，如果有一个登录了，同一个用户在其他地方不能登录
        http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(false);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**");
    }

    /**
     * 自定义验证逻辑
     * 
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(provider);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
