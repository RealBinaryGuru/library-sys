package com.seanglay.library_sys.controller

import com.seanglay.library_sys.model.Books
import com.seanglay.library_sys.service.BookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/books")
class BookController(private val bookService: BookService) {
    @PostMapping
    fun createBook(@RequestBody book: Books): ResponseEntity<Books> {
        return ResponseEntity.ok(bookService.createBook(book))
    }

    @GetMapping
    fun listAllBooks(): ResponseEntity<List<Books>> {
        return ResponseEntity.ok(bookService.getAll())
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: String): ResponseEntity<Books> {
        return ResponseEntity.ok(bookService.getBookById(id))
    }

    @PutMapping("/{id}")
    fun updateBook(@PathVariable id: String, @RequestBody book: Books): ResponseEntity<Books> {
        return ResponseEntity.ok(bookService.updateBook(id, book))
    }


}