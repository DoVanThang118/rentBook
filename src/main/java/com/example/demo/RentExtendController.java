package com.example.demo;

import com.example.demo.entities.Rent;
import com.example.demo.impls.RentRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RentExtendController implements Initializable {
    public static Rent extendBook;
    public DatePicker dpExp;
    public Text txtBook;

    public void submit() {
        try {
            String epxDate = dpExp.getValue().toString();
            extendBook.setExpDate(epxDate);
            extendBook.setStatus(0);
            RentRepository extend = new RentRepository();
            if(extend.update(extendBook)){
                Parent back = FXMLLoader.load(getClass().getResource("rent/list.fxml"));
                Main.rootStage.setTitle("Book Rent");
                Main.rootStage.setScene(new Scene(back,600,400));
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (extendBook != null){
            txtBook.setText(extendBook.getBookName());
        }
    }

    public static void extend() throws IOException {
        Parent back = FXMLLoader.load(RentRepayController.class.getResource("rent/extend.fxml"));
        Main.rootStage.setTitle("Book Rent");
        Main.rootStage.setScene(new Scene(back,600,400));
    }

    public void goHome() throws IOException {
        Parent back = FXMLLoader.load(BookEditController.class.getResource("rent/list.fxml"));
        Main.rootStage.setTitle("Book Rent");
        Main.rootStage.setScene(new Scene(back,600,400));
    }
}
