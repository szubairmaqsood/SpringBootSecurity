package com.example.SpringSecuityKotlinV2

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
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
    @Bean
    fun getPasswordEncoder():PasswordEncoder{
        return NoOpPasswordEncoder.getInstance()
    }
}