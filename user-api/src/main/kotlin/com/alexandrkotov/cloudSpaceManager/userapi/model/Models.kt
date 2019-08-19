package com.alexandrkotov.cloudSpaceManager.userapi.model

import org.springframework.security.core.GrantedAuthority

data class WebUser(val username: String, val password: String)

enum class Role : GrantedAuthority {
    USER {
        override fun getAuthority(): String {
            return name
        }
    }
}