package com.ufms.progweb.controller;

import com.ufms.progweb.model.Sneaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sneakers")
public class SneakerController {

    private List<Sneaker> sneakers = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Sneaker> createSneaker(@RequestBody Sneaker sneaker) {
        sneakers.add(sneaker);
        return new ResponseEntity<>(sneaker, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Sneaker>> getAllSneakers() {
        return new ResponseEntity<>(sneakers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sneaker> getSneakerById(@PathVariable Long id) {
        for (Sneaker sneaker : sneakers) {
            if (sneaker.getId().equals(id)) {
                return new ResponseEntity<>(sneaker, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sneaker> updateSneaker(@PathVariable Long id, @RequestBody Sneaker sneakerDetails) {
        for (Sneaker sneaker : sneakers) {
            if (sneaker.getId().equals(id)) {
                sneaker.setNome(sneakerDetails.getNome());
                sneaker.setPreco(sneakerDetails.getPreco());
                sneaker.setDescricao(sneakerDetails.getDescricao());
                return new ResponseEntity<>(sneaker, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSneaker(@PathVariable Long id) {
        sneakers.removeIf(sneaker -> sneaker.getId().equals(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}