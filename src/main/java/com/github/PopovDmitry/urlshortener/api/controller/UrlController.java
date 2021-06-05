package com.github.PopovDmitry.urlshortener.api.controller;

import com.github.PopovDmitry.urlshortener.api.dto.UrlDTO;
import com.github.PopovDmitry.urlshortener.api.service.UrlService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/api/public")
@AllArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/generate")
    public ResponseEntity<UrlDTO> generate(@RequestBody UrlDTO urlDTO) {
        return ResponseEntity.ok(
                new UrlDTO(
                        urlService.getShortLink(urlDTO)));
    }
}
