package com.disqo.bestnote.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BestNoteController {

    @GetMapping
    public String testNote(){
        return "test note";
    }
}
