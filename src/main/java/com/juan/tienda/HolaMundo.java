package com.juan.tienda;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class HolaMundo {

    @GetMapping("/")
    public String saludo() {
        return "Hola mundo!!!";
    }
}
