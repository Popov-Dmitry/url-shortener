package com.github.PopovDmitry.urlshortener.api.repository;

import com.github.PopovDmitry.urlshortener.api.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UrlRepository extends JpaRepository<Url, UUID> {

    Optional<Url> findByOriginalLink(String originalLink);

}
