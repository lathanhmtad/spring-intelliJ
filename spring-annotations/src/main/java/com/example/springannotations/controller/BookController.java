package com.example.springannotations.controller;

import com.example.springannotations.beans.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

    @RequestMapping("/hello-world")
    @ResponseBody
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/book")
    @ResponseBody
    public Book getBook() {
        Book book = new Book(1, "Core Java", "Learn Core Java and Latest features");
        return book;
    }
}
