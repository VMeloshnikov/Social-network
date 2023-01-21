package ru.skillbox.diplom.group33.social.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Data
@RestController
public class Crud {

    @Autowired
    private final BaseRepository baseRepository;

    @GetMapping("/test/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(baseRepository.findById(id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/test/")
    public ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(baseRepository.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/test/")
    public ResponseEntity<?> update() {
        Iterable<?> iterable = baseRepository.findAll();
        ArrayList<Object> arrayList = new ArrayList<>();
        for (Object obj : iterable) {
            arrayList.add(obj);
        }
        baseRepository.saveAll(arrayList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/test/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        baseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
