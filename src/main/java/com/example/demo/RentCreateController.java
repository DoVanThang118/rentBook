package com.example.demo;

import com.example.demo.entities.Book;
import com.example.demo.entities.Rent;
import com.example.demo.impls.BookRepository;
import com.example.demo.impls.RentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.time.format.DateTimeFormatter;

public class RentCreateController implements Initializable {
    public ComboBox<Book> cbBook;
    public DatePicker dpRent;
    public DatePicker dpExp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BookRepository rp = new BookRepository();
        ObservableList<Book> ls = FXCollections.observableArrayList();
        ls.addAll(rp.all());
        cbBook.setItems(ls);
    }

    public void submit(ActionEvent event) {

        try {
            Book book = cbBook.getSelectionModel().getSelectedItem();

            LocalDate rentDate = dpRent.getValue();
            String rd = rentDate.toString();

            LocalDate expDate = dpExp.getValue();
            String ed = expDate.toString();

            Rent rent = new Rent(null, book.getId(), rd, ed,0);
            RentRepository rp = new RentRepository();

            if (rp.create(rent)){
                goRent();
            }else {
                System.out.println("error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void goRent() throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("rent/list.fxml"));
        Main.rootStage.setTitle("Book Rent");
        Main.rootStage.setScene(new Scene(back,600,400));
    }

    public void goHome() throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.rootStage.setTitle("Book Rent");
        Main.rootStage.setScene(new Scene(back,600,400));
    }
}
