package com.accenture.domain;

import java.io.Serializable;



/**
 * 
 * @author Marten Deinum
 * @author Koen Serneels
 *
 */

public class Category implements Serializable {

    private Long id;


    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
