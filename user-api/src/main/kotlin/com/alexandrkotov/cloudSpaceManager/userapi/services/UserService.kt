package com.alexandrkotov.cloudSpaceManager.userapi.services

import com.alexandrkotov.cloudSpaceManager.userapi.model.Role
import com.alexandrkotov.cloudSpaceManager.userapi.model.UserEntity
import com.alexandrkotov.cloudSpaceManager.userapi.model.WebUser
import com.alexandrkotov.cloudSpaceManager.userapi.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    val userRepository: UserRepository,
    val passwordEncoder: PasswordEncoder
) {

    fun addUser(webUser: WebUser) {
        //todo check user exists
        userRepository.save(
            UserEntity(
                name = webUser.username,
                username = webUser.username,
                password = passwordEncoder.encode(webUser.password),
                active = true,
                grants = mutableListOf(Role.USER)
            )
        )
    }

    fun loadUserByLogin(string: String) = userRepository.findByUsername(string)
}