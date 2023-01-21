package ru.skillbox.diplom.group33.social.service;

import org.springframework.data.repository.CrudRepository;

public interface BaseRepository<T> extends CrudRepository <T, Long> {
}
