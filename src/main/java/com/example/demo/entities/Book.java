package com.example.demo.entities;

import com.example.demo.BookEditController;
import javafx.scene.control.Button;

public class Book {
    public Integer id;

    public String name;
    public String author;
    public Integer qty;
    public Button edit;

    public Book() {
    }
    public Book(Integer id, String name, String author, Integer qty) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.qty = qty;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event)->{
            try {
                BookEditController.editedBook = this;
                BookEditController.gotoEdit();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        });
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return getName();
    }
}
