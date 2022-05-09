package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customers")
public class Customers {

    @Id
    public Integer id;
    @Field
    private String name;

    public Customers(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
     * public String getId() {
     * return _id.toString();
     * }
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void finalize() {
        System.out.println("One customers has been destroyed.");
    }
}
