package com.portfolio.be.feature.sign.dto

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class SignDTO (
    var email:String,
    private var password:String? = null
):UserDetails{
    constructor(signInDTO: SignInDTO.InfoDTO) : this(
        email = signInDTO.email!!,
        password = signInDTO.password
    )

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
      /*  val authorities = arrayListOf<GrantedAuthority>()
        authorities.add(SimpleGrantedAuthority("ROLE_USER"))
        return authorities*/
        return null
    }

    override fun getPassword(): String? {
       return this.password
    }

    override fun getUsername(): String {
        return ""
    }

    override fun isAccountNonExpired(): Boolean {
        return false
    }

    override fun isAccountNonLocked(): Boolean {
        return false
    }

    override fun isCredentialsNonExpired(): Boolean {
        return false
    }

    override fun isEnabled(): Boolean {
        return false
    }
}