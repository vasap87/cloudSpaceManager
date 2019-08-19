package com.alexandrkotov.cloudSpaceManager.userapi.controller

import com.alexandrkotov.cloudSpaceManager.userapi.model.WebUser
import com.alexandrkotov.cloudSpaceManager.userapi.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RegistrationController {

    @Autowired(required = false)
    lateinit var userService: UserService

    @PostMapping("/registration")
    fun registration(@RequestBody user: WebUser): ResponseEntity<String> {
        userService.addUser(user)
        return ResponseEntity(HttpStatus.CREATED)
    }
}