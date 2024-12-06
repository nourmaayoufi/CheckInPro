package edu.iset.atelierspringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Utilisateur")
public class utilisateurController {

    @GetMapping
    public String getUtilisateur() {
        return "Hello, Utilisateur!"; // You can return whatever data you need here
    }
}
