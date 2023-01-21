package ru.skillbox.diplom.group33.social.service;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Boolean isDeleted;
}
