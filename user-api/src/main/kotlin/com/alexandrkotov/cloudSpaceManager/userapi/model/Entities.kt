package com.alexandrkotov.cloudSpaceManager.userapi.model

import org.jetbrains.annotations.NotNull
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    @JvmField
    @NotNull
    val username: String,
    @JvmField
    @NotNull
    val password: String,
    val name: String,
    val active: Boolean = false,
    val googleName: String? = null,
    val googleUsername: String? = null,

    @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role")
    @Enumerated(EnumType.STRING)
    val grants: MutableCollection<GrantedAuthority>
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return grants
    }

    override fun isEnabled() = active

    override fun getUsername() = username

    override fun isCredentialsNonExpired() = true

    override fun getPassword() = password

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

}