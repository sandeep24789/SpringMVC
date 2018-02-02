package com.accenture.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;




public class Book implements Serializable {

    private Long id;

    
    private String title;

    private String description;
    private BigDecimal price;
    private Integer year;
    private String author;
    private String Isbn;


    private Category category;

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getIsbn() {
        return this.Isbn;
    }

    public void setIsbn(String isbn) {
        this.Isbn = isbn;
    }

    }
