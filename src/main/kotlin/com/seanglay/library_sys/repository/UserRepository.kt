package com.seanglay.library_sys.repository

import com.seanglay.library_sys.model.Users
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface UserRepository : MongoRepository<Users, String> {
    fun findByUsername(username: String): Optional<Users>}