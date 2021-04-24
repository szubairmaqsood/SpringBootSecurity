package com.example.SpringSecuityKotlinV2

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeResource {
    @GetMapping("/")
    fun home():String{
        return ("Welcome")
    }

    @GetMapping("/user")
    fun auser():String{
        return ("Welcome User")
    }

    @GetMapping("/admin")
    fun admin():String{
        return ("Welcome Admin")
    }
}