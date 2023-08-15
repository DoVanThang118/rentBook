package com.example.demo.entities;

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
    private Date rentDate;
    private Date expDate;
    private Integer status;
    private String bookName;
    private String statusLabel;
    private Button repay;

    public Rent(){}

    public Rent(Integer id, Integer bookId, Date rentDate, Date expDate, Integer status) {
        this.id = id;
        this.bookId = bookId;
        this.rentDate = rentDate;
        this.expDate = expDate;
        this.status = status;
        this.repay = new Button("Repay");
        this.repay.setOnAction((event)->{
            try {
                RentRepayController.repayBook = this;
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

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
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
        return status==0?"Chưa trả":"Đã trả";
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
