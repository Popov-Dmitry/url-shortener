package com.github.PopovDmitry.urlshortener.api.controller;

import com.github.PopovDmitry.urlshortener.api.dto.UrlDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/public")
public class UrlController {

    @PostMapping("/generate")
    public ResponseEntity<?> generate(@RequestBody UrlDTO urlDTO) {

        return null;
    }
}
