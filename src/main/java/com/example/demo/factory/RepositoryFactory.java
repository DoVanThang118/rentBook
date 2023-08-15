package com.example.demo.factory;

import com.example.demo.enums.RepoType;
import com.example.demo.impls.BookRepository;
import com.example.demo.impls.RentRepository;
import com.example.demo.interfaces.IRepository;

public class RepositoryFactory {
    private RepositoryFactory(){
    }

    public static IRepository createRepository(RepoType type){
        switch (type){
            case BOOK: return new BookRepository();
            case RENT: return new RentRepository();
            default: throw new IllegalArgumentException("Thiếu tham số rồi");
        }
    }
}
