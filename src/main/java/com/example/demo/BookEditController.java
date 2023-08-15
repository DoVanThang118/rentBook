package com.example.demo;

import com.example.demo.entities.Book;
import com.example.demo.impls.BookRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class BookEditController implements Initializable {
    public static Book editedBook;
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;

    public static void gotoEdit() throws IOException {
        Parent back = FXMLLoader.load(BookEditController.class.getResource("book/edit.fxml"));
        Main.rootStage.setTitle("Book Rent");
        Main.rootStage.setScene(new Scene(back,600,400));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (editedBook !=null){
            txtName.setText(editedBook.getName());
            txtAuthor.setText(editedBook.getAuthor());
            txtQty.setText(editedBook.getQty().toString());
        }
    }

    public void submit() {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            Integer qty = Integer.parseInt(txtQty.getText());
            editedBook.setName(name);
            editedBook.setAuthor(author);
            editedBook.setQty(qty);
            BookRepository rp = new BookRepository();
            if(rp.update(editedBook)){
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

    public void delete(ActionEvent event) {
        try{
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Book?");
            alert.setHeaderText("Are you sure delete book: "+editedBook.getName());
            Optional<ButtonType> option = alert.showAndWait();

            if(option.get() == ButtonType.OK){
                BookRepository rp = new BookRepository();
                if(rp.delete(editedBook)){
                    back();
                }else {
                    System.out.println("Error");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
