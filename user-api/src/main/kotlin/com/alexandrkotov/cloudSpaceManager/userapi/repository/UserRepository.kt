package com.alexandrkotov.cloudSpaceManager.userapi.repository

import com.alexandrkotov.cloudSpaceManager.userapi.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByUsername(email: String): UserEntity?
}