package com.seanglay.library_sys.service

import com.seanglay.library_sys.model.Books
import com.seanglay.library_sys.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {
    fun createBook(book: Books): Books {
        return bookRepository.save(book)
    }

    fun getAll(): List<Books> {
        return bookRepository.findAll()
    }

    fun getBookById(id: String): Books {
        return bookRepository.findById(id).orElse(null)
    }

    fun updateBook(id: String, updatedBook: Books): Books {
        val existingBook = bookRepository.findById(id).orElseThrow { RuntimeException("Book with ID $id not found") }

        with(existingBook) {
            title = updatedBook.title
            author = updatedBook.author
            description = updatedBook.description
            price = updatedBook.price
            genre = updatedBook.genre
            publishedDate = updatedBook.publishedDate
        }

        return bookRepository.save(existingBook)
    }
}