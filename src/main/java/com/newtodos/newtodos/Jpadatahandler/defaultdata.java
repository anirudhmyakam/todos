package com.newtodos.newtodos.Jpadatahandler;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.newtodos.newtodos.Todos.Todo;

@Component
public class defaultdata implements CommandLineRunner {

    @Autowired
    private jparepo jpa;

    @Override
    public void run(String... args) throws Exception{

        jpa.insert(new Todo(1, "anirudh", "dont do web", new Date(), false));
        jpa.insert(new Todo(2, "anirudh", "do gym", new Date(), false));
        jpa.insert(new Todo(3, "anni", "call", new Date(), false));
        jpa.insert(new Todo(4, "anni", "meet", new Date(), false));
    }
    
}
