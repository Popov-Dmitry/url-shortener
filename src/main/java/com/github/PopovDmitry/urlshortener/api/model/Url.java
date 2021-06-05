package com.github.PopovDmitry.urlshortener.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "urls")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_link")
    private String originalLink;

    @Column(name = "short_link")
    private String shortLink;

    public Url(String originalLink) {
        this.originalLink = originalLink;
    }
}
