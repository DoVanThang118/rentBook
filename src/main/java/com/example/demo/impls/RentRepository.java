package com.example.demo.impls;

import com.example.demo.database.Connector;
import com.example.demo.entities.Rent;
import com.example.demo.interfaces.IRepository;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RentRepository implements IRepository<Rent> {

    @Override
    public ArrayList<Rent> all() {
        ArrayList<Rent> list = new ArrayList<>();
        try {
            String sql_txt = "select * from rents";
            Connector connector = Connector.getInstance();
            ResultSet rs = connector.query(sql_txt);
            while (rs.next()){
                list.add(new Rent(
                        rs.getInt("id"),
                        rs.getInt("bookId"),
                        rs.getDate("rent_date"),
                        rs.getDate("exp_date"),
                        rs.getInt("status")
                ));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public boolean create(Rent rent) {
        try {
            String sql_txt = "insert into rents(bookId,rent_date,exp_date) value(?,?,?)";
            Connector connector = Connector.getInstance();
            ArrayList arrayList = new ArrayList();
            arrayList.add(rent.getBookId());
            arrayList.add(rent.getRentDate());
            arrayList.add(rent.getExpDate());
            if (connector.execute(sql_txt,arrayList)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Rent rent) {
        try {
            String sql_txt = "update rents set exp_date=? where id=?";
            Connector connector = Connector.getInstance();
            ArrayList arrayList = new ArrayList();
            arrayList.add(rent.getExpDate());
            arrayList.add(rent.getId());
            if (connector.execute(sql_txt,arrayList)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Rent rent) {
        return false;
    }

    @Override
    public Rent findOne(Integer id) {
        return null;
    }
}
