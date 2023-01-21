package ru.skillbox.diplom.group33.social.service;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
public class Captcha {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID secret;

    private String code;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime time;

    @Transient
    private BufferedImage image;

}
