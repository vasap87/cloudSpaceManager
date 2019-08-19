package com.alexandrkotov.cloudSpaceManager.userapi.repository

import com.alexandrkotov.cloudSpaceManager.userapi.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByUsername(email: String): UserEntity?
}