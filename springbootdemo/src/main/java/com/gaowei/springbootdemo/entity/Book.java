package com.gaowei.springbootdemo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/30 17:16
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String reader;
    private String isbn;
    private String title;
    private String author;
    private String description;

}
