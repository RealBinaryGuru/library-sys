package com.seanglay.library_sys.repository

import com.seanglay.library_sys.model.Orders
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : MongoRepository<Orders, String> {}