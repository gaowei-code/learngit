package com.gaowei.springbootdemo.controller;

import com.gaowei.springbootdemo.dao.BookDao;
import com.gaowei.springbootdemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/30 17:14
 */
@Controller
@RequestMapping("test")
public class TestController {

    private BookDao bookDao;

    public TestController(BookDao bookDao){
        this.bookDao = bookDao;
    }

    @GetMapping("/{author}")
    public String getBoosByAuthor(@PathVariable String author, Model model){
        List<Book> books = bookDao.findBooksByAuthor(author);
        if (books != null){
            model.addAttribute("books", books);
        }
        return "bookList";
    }

    @PostMapping("/add")
    @ResponseBody
    public void addBook(Book book){
        Book book1 = bookDao.save(book);
    }
}
