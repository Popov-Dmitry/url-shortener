package com.github.PopovDmitry.urlshortener.api.service;

import com.github.PopovDmitry.urlshortener.api.dto.UrlDTO;
import com.github.PopovDmitry.urlshortener.api.model.Url;
import com.github.PopovDmitry.urlshortener.api.repository.UrlRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    private final static String PREFIX = "http://localhost:8080/";

    public String getShortLink(UrlDTO urlDTO) {

        Optional<Url> optionalUrl = urlRepository.findByOriginalLink(urlDTO.getOriginalUrl());

        if (optionalUrl.isPresent()) {
            return optionalUrl.get().getShortLink();
        }

        Url url = new Url(urlDTO.getOriginalUrl());
        url.setShortLink(generateShortLink(urlDTO.getOriginalUrl()));

        urlRepository.save(url);

        return url.getShortLink();
    }

    private String generateShortLink(String originalLink) {
        return PREFIX +
                DigestUtils
                        .md5DigestAsHex(
                                originalLink.getBytes(StandardCharsets.UTF_8)
                        ).substring(0, 4);
    }
}
