package com.global.book.controller;

import com.global.book.entity.Book;
import com.global.book.entity.BookDTO;
import com.global.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Book book = bookService.findById(id);

        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setPrice(book.getPrice());

        dto.setAuther(book.getAuther());

        return ResponseEntity.ok(dto);
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping("insert")
    public ResponseEntity<?> insert(@RequestBody Book entity) {
        return ResponseEntity.ok(bookService.insert(entity));
    }

    @PutMapping("")
    public ResponseEntity<?> update(Book entity) {
        return ResponseEntity.ok(bookService.update(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
