package com.example.demo;

import com.example.demo.entities.Book;
import com.example.demo.enums.RepoType;
import com.example.demo.impls.BookRepository;
import com.example.demo.factory.RepositoryFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookListController implements Initializable {
    public TableView<Book> tbBooks;
    public TableColumn<Book,Integer> tdId;
    public TableColumn<Book,String> tdName;
    public TableColumn<Book,String> tdAuthor;
    public TableColumn<Book,Integer> tdQty;
    public TableColumn<Book, Button> tdEdit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tdId.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        tdAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        tdQty.setCellValueFactory(new PropertyValueFactory<Book, Integer>("qty"));
        tdEdit.setCellValueFactory(new PropertyValueFactory<Book, Button>("edit"));

        ObservableList<Book> ls = FXCollections.observableArrayList();
        // lay data from database
        BookRepository rp = (BookRepository)RepositoryFactory.createRepository(RepoType.BOOK);
        ls.addAll(rp.all());
        tbBooks.setItems(ls);
    }
    public void backHome() throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.rootStage.setTitle("Book Rent");
        Main.rootStage.setScene(new Scene(back,600,400));
    }

    public void addBook() throws IOException {
        Parent add = FXMLLoader.load(getClass().getResource("book/create.fxml"));
        Main.rootStage.setTitle("Add Book");
        Main.rootStage.setScene(new Scene(add,600,400));
    }
}
