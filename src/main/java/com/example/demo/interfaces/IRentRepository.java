package com.example.demo.interfaces;

import java.util.ArrayList;

public interface IRentRepository<Rent> {
    ArrayList<Rent> all();
    boolean create(Rent rent);
    boolean update(Rent rent);
    boolean delete(Rent rent);
    Rent findOne(Integer id);
}
