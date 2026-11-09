package com.darkset;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    public int getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "name" , nullable = false)
    private String name;

    public Category(String name){
        this.name = name;
    }

    protected Category() {

    }
}
