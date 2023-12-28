package com.rest.book.bootrestbook.services;

import com.rest.book.bootrestbook.dao.BookRepository;
import com.rest.book.bootrestbook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookService {

//    public static List<Book> book = new ArrayList<>();
    @Autowired
    private BookRepository bookRepository;
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book getBookById(int id){
        try{
            return bookRepository.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void addBook(Book b){
        bookRepository.save(b);
    }

    public void delBookById(int id){
        bookRepository.deleteById(id);
    }

    public void updateBookById(int id, Book b){
//        for(Book b2: book){
//            if(b2.getId()==id) {
//                b2.setName(b.getName());
//                b2.setAuthor(b.getAuthor());
//            }
//        }

//        Book b2 = bookRepository.findById(id);
//        b2.setName(b.getName());
//        b2.setAuthor(b.getAuthor());

        b.setId(id);
        bookRepository.save(b);
    }

    public void deleteBooks(){
        bookRepository.deleteAll();
    }
}
