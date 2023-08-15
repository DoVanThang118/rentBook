package com.example.demo;

import com.example.demo.entities.Book;
import com.example.demo.impls.BookRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;

public class BookCreateController {
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;

    public void submit() {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            Integer qty = Integer.parseInt(txtQty.getText());
            Book book =  new Book(null,name,author,qty);
            BookRepository rp = new BookRepository();
            if(rp.create(book)){
                back();
            }else {
                System.out.println("Error");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void back() throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("book/list.fxml"));
        Main.rootStage.setTitle("Book Rent");
        Main.rootStage.setScene(new Scene(back,600,400));
    }
}
