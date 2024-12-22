package com.seanglay.library_sys.controller

import com.seanglay.library_sys.dto.LoginRequestDTO
import com.seanglay.library_sys.dto.TokenResponseDTO
import com.seanglay.library_sys.dto.UserResponseDTO
import com.seanglay.library_sys.model.Users
import com.seanglay.library_sys.service.AuthService
import com.seanglay.library_sys.security.JwtUtil
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.AuthenticationException


@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authService: AuthService,
    private val authenticationManager: AuthenticationManager,
    private val jwtUtil: JwtUtil
) {
    @PostMapping("/register")
    fun register(@RequestBody user: Users): ResponseEntity<UserResponseDTO> {
        val registeredUser = authService.register(user)
        return ResponseEntity.ok(registeredUser)
    }

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginRequestDTO): ResponseEntity<Any> {
        return try {
            val user = authService.findByUsername(loginDto.username)
            if (user == null) {
                return ResponseEntity.status(404).body("User not found")
            }

            authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(loginDto.username, loginDto.password)
            )
            val userDetails = authService.loadUserByUsername(loginDto.username)
            val token = jwtUtil.generateToken(userDetails)

            ResponseEntity.ok(TokenResponseDTO(token))
        } catch (e: AuthenticationException) {
            ResponseEntity.status(401).body("Invalid credentials")
        }
    }


}