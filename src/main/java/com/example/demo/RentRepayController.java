package com.example.demo;

import com.example.demo.entities.Rent;
import com.example.demo.impls.RentRepository;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class RentRepayController {
    public static Rent repayBook;

    public static void repay() {
        try {
            repayBook.setStatus(1);
            RentRepository rr = new RentRepository();
            if(rr.setStatus(repayBook)){
                Parent back = FXMLLoader.load(RentRepayController.class.getResource("rent/list.fxml"));
                Main.rootStage.setTitle("Book Rent");
                Main.rootStage.setScene(new Scene(back,600,400));
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
