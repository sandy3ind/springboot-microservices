package com.springbootzuulapigateway;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
    public void configure(HttpSecurity http) throws Exception {
        http           
            .authorizeRequests()
            .antMatchers("/api/organization/**")
            .hasAnyAuthority("ORGANIZATION_READ", "ORGANIZATION_CREATE", "ORGANIZATION_UPDATE", "ORGANIZATION_DELETE")
            .antMatchers("/api/department/**")
            .hasAnyAuthority("ORGANIZATION_READ", "ORGANIZATION_CREATE", "ORGANIZATION_UPDATE", "ORGANIZATION_DELETE",
            		"DEPARTMENT_READ", "DEPARTMENT_CREATE", "DEPARTMENT_UPDATE", "DEPARTMENT_DELETE")
            .antMatchers("/api/employee/**")
            .hasAnyAuthority("ORGANIZATION_READ", "ORGANIZATION_CREATE", "ORGANIZATION_UPDATE", "ORGANIZATION_DELETE",
            		"DEPARTMENT_READ", "DEPARTMENT_CREATE", "DEPARTMENT_UPDATE", "DEPARTMENT_DELETE",
            		"EMPLOYEE_READ", "EMPLOYEE_CREATE", "EMPLOYEE_UPDATE", "EMPLOYEE_DELETE")
            .anyRequest().authenticated();
    }
}
