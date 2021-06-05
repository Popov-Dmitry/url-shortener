package com.github.PopovDmitry.urlshortener.controller;

import com.github.PopovDmitry.urlshortener.api.service.UrlService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SiteController {

    private final UrlService urlService;

    @Value("${site.url}")
    private String siteUrl;


    @GetMapping("")
    public String getMainPage() {
        return "";
    }

    @GetMapping("/*")
    public ResponseEntity<?> redirect(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect(urlService.getOriginalLink(
                    request.getRequestURL()
                            .toString()
                            .replaceAll(siteUrl, "")));
        } catch (NotFoundException | IOException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
