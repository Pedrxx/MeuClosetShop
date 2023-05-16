package meuclosetshop.backend.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // http://localhost:8080/api/

public class Hello {

    @GetMapping("/")
    public String sayHello() {
        return "Ola mundo" + new Date();
    }
    
}