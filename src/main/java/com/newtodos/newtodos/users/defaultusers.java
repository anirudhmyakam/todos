package com.newtodos.newtodos.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class defaultusers implements CommandLineRunner{

    @Autowired
    private usersrepo usrrep;

    @Override
    public void run(String... args) throws Exception{
        usrrep.newuser(new users(1,"anni","@123"));
        usrrep.newuser(new users(2,"anirudh","0203"));

    }
    
}
