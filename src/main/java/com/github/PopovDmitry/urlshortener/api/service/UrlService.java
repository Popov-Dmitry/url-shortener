package com.github.PopovDmitry.urlshortener.api.service;

import com.github.PopovDmitry.urlshortener.api.dto.UrlDTO;
import com.github.PopovDmitry.urlshortener.api.model.Url;
import com.github.PopovDmitry.urlshortener.api.repository.UrlRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    @Value("${site.url}")
    private String prefix;

    public String getShortLink(UrlDTO urlDTO) {
        Optional<Url> optionalUrl = urlRepository.findByOriginalLink(urlDTO.getUrl());

        if (optionalUrl.isPresent()) {
            return optionalUrl.get().getShortLink();
        }

        Url url = new Url(urlDTO.getUrl());
        url.setShortLink(generateShortLink(urlDTO.getUrl()));

        urlRepository.save(url);

        return url.getShortLink();
    }

    public String getOriginalLink(String shortLink) throws NotFoundException {
        Optional<Url> optionalUrl = urlRepository.findByShortLink(shortLink);

        if (optionalUrl.isPresent()) {
            return optionalUrl.get().getOriginalLink();
        }
        throw new NotFoundException("Url is not found.");
    }

    private String generateShortLink(String originalLink) {
        return prefix +
                DigestUtils
                        .md5DigestAsHex(
                                originalLink.getBytes(StandardCharsets.UTF_8)
                        ).substring(0, 4);
    }
}
