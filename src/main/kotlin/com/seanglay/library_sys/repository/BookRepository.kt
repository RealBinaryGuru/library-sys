package com.seanglay.library_sys.repository

import com.seanglay.library_sys.model.Books
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : MongoRepository<Books, String> {}