package com.gaowei.springbootdemo.dao;

import com.gaowei.springbootdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/30 18:18
 */
public interface BookDao extends JpaRepository<Book, Long> {

    /**
     * 根据作者查询书籍
     * @param author 作者
     * @return
     */
    List<Book> findBooksByAuthor(String author);
}
