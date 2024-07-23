package com.newtodos.newtodos.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class basicauth {
    @GetMapping(path="/basicauth")
    public authenticatoinbean getauthorized(){
        return new authenticatoinbean("You are Authenticated");
    }



}