package com.example.demo.entities;

import com.example.demo.BookEditController;
import com.example.demo.RentExtendController;
import com.example.demo.enums.RepoType;
import com.example.demo.factory.RepositoryFactory;
import com.example.demo.RentRepayController;
import com.example.demo.impls.BookRepository;
import javafx.scene.control.Button;

import java.time.LocalDate;
import java.util.Date;

public class Rent {
    private Integer id;
    private Integer bookId;
    private String rentDate;
    private String expDate;
    private Integer status;
    private String bookName;
    private String statusLabel;
    private Button repay;

    public Rent(){}

    public Rent(Integer id, Integer bookId, String rentDate, String expDate, Integer status) {
        this.id = id;
        this.bookId = bookId;
        this.rentDate = rentDate;
        this.expDate = expDate;
        this.status = status;
        this.repay = new Button(getStatusLabel());
        this.repay.setOnAction((event)->{
            try {
                if (status == 0){
                    RentRepayController.repayBook = this;
                    RentRepayController.repay();
                }else {
                    RentExtendController.extendBook = this;
                    RentExtendController.extend();
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBookName() {
        return this.book().getName();
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getStatusLabel() {
        return status==0?"repay":"extend";
    }

    public Book book(){
        //return ((BookRepository) RepositoryFactory.createRepository(RepoType.BOOK)).findOne(this.getBookId());
        BookRepository br =new BookRepository();
        return br.findOne(this.bookId);
    }

    public Button getRepay() {
        return repay;
    }

    public void setRepay(Button repay) {
        this.repay = repay;
    }
}
