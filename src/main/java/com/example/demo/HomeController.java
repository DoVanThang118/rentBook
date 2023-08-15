package com.example.demo;

import com.example.demo.entities.Book;
import com.example.demo.entities.Rent;
import com.example.demo.enums.RepoType;
import com.example.demo.factory.RepositoryFactory;
import com.example.demo.impls.BookRepository;
import com.example.demo.impls.RentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    public TableView<Book> tbBooks;
    public TableColumn<Book, String> tdName;
    public TableColumn<Book, String> tdAuthor;
    public TableColumn<Rent, String> tdBook;
    public TableColumn<Rent, Date> tdExp;
    public TableView<Rent> tbRents;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tdName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        tdAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));

        tdBook.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        tdExp.setCellValueFactory(new PropertyValueFactory<>("expDate"));

        ObservableList<Book> ls = FXCollections.observableArrayList();
        // lay data from database
        BookRepository rp = (BookRepository) RepositoryFactory.createRepository(RepoType.BOOK);
        ls.addAll(rp.all());
        tbBooks.setItems(ls);

        RentRepository rent = (RentRepository) RepositoryFactory.createRepository(RepoType.RENT);
        tbRents.getItems().addAll(rent.all());
    }

    public void goBook() throws IOException{
        Parent list = FXMLLoader.load(getClass().getResource("book/list.fxml"));
        Main.rootStage.setTitle("list book");
        Main.rootStage.setScene(new Scene(list,600,400));
    }

    public void goRent() throws IOException{
        Parent list = FXMLLoader.load(getClass().getResource("rent/list.fxml"));
        Main.rootStage.setTitle("list rent");
        Main.rootStage.setScene(new Scene(list,600,400));
    }

    public void goRentBook() throws  IOException {
        Parent list = FXMLLoader.load(getClass().getResource("rent/create.fxml"));
        Main.rootStage.setTitle("Create rent");
        Main.rootStage.setScene(new Scene(list,600,400));
    }
}
