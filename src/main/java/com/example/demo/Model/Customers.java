package com.example.demo.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customers")
public class Customers {

    @Id
    public Integer _id;
    @Field
    private String name;

    public Customers(Integer _id, String name) {
        this._id = _id;
        this.name = name;
    }

    public String getId() {
        return _id.toString();
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
