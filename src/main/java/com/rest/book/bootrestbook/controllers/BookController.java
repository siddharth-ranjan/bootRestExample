package com.rest.book.bootrestbook.controllers;

import com.rest.book.bootrestbook.entities.Book;
import com.rest.book.bootrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    public BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){

        try{
            List<Book> l = bookService.getAllBooks();
            return ResponseEntity.of(Optional.of(l));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
        try{
            Book b = bookService.getBookById(id);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/book")
    public ResponseEntity<Void> addBook(@RequestBody Book book){
        try{
            bookService.addBook(book);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> delById(@PathVariable("id") int id){
        try{
            bookService.delBookById(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") int id, @RequestBody Book book){
        try{
            bookService.updateBookById(id, book);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/books")
    public ResponseEntity<?> delBooks(){
        try{
            bookService.deleteBooks();
            return ResponseEntity.ok().build();
        } catch (Exception e){
          return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

}
