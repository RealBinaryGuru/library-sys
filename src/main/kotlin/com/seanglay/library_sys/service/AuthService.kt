package com.seanglay.library_sys.service

import com.seanglay.library_sys.dto.UserResponseDTO
import com.seanglay.library_sys.model.Users
import com.seanglay.library_sys.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

@Service
class AuthService(
    private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder
) : UserDetailsService {
    fun register(user: Users): UserResponseDTO? {
        val encryptedPassword = passwordEncoder.encode(user.password)
        val newUser = user.copy(password = encryptedPassword)
        val savedUser = userRepository.save(newUser)
        return savedUser.id?.let { UserResponseDTO(id = it, username = savedUser.username) }
    }

    fun findByUsername(username: String): Users? {
        return userRepository.findByUsername(username).orElse(null)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username).orElseThrow { UsernameNotFoundException("User not found") }
        return User(user.username, user.password, emptyList())
    }
}