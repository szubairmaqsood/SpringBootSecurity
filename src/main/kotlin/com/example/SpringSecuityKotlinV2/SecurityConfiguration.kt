package com.example.SpringSecuityKotlinV2

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
class SecurityConfiguration:WebSecurityConfigurerAdapter() {
    override fun configure(auth: AuthenticationManagerBuilder?) {
       //Set the confiugration
        auth?.inMemoryAuthentication()
                ?.withUser("root")
                ?.password("root")
                ?.roles("User")
                ?.and()
                ?.withUser("admin")
                ?.password("admin")
                ?.roles("Admin")
    }

    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()
                ?.antMatchers("/admin")?.hasRole("Admin")
                ?.antMatchers("/user")?.hasRole("User")
                ?.antMatchers("/","static/css","static/js")?.permitAll()
                ?.and()?.formLogin()
    }
    @Bean
    fun getPasswordEncoder():PasswordEncoder{
        return NoOpPasswordEncoder.getInstance()
    }
}