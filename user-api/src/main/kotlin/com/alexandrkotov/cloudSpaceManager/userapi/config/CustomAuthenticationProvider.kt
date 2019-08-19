package com.alexandrkotov.cloudSpaceManager.userapi.config

import com.alexandrkotov.cloudSpaceManager.userapi.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationProvider(
    val userService: UserService,
    val passwordEncoder: PasswordEncoder
) : AuthenticationProvider {

    override fun authenticate(auth: Authentication): Authentication {
        val username = auth.name
        val pass = auth.credentials as String

        val user = userService.loadUserByLogin(username)
        if (user != null) {
            if (!passwordEncoder.matches(pass, user.password)) {
                throw BadCredentialsException("Wrong password")
            }
            return UsernamePasswordAuthenticationToken(username, pass, user.authorities)
        }
        throw BadCredentialsException("Username not found")
    }

    override fun supports(authentication: Class<*>?) =
        authentication!! == UsernamePasswordAuthenticationToken::class.java
}