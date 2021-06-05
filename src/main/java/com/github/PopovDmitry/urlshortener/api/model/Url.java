package com.github.PopovDmitry.urlshortener.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "urls")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Url {

    @Id
    private UUID uuid;

    @Column(name = "original_link")
    private String originalLink;

    @Column(name = "short_link")
    private String shortLink;
}
