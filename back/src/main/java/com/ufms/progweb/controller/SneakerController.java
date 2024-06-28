package com.ufms.progweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.ufms.progweb.model.Sneaker;
import com.ufms.progweb.services.SneakerService;
@RestController
@RequestMapping("/sneakers")
public class SneakerController {

    @Autowired
    private SneakerService sneakerService;

    @PostMapping
    public ResponseEntity<Sneaker> createSneaker(@RequestBody Sneaker sneaker) {
        sneakerService.saveSneaker(sneaker);
        return new ResponseEntity<>(sneaker, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sneaker> updateSneaker(@PathVariable Long id, @RequestBody Sneaker sneakerDetails) {
        Sneaker updatedSneaker = sneakerService.updateSneaker(id, sneakerDetails);
        if (updatedSneaker != null) {
                return new ResponseEntity<>(updatedSneaker, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSneaker(@PathVariable Long id) {
        if(sneakerService.searchById(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else{
            sneakerService.deleteSneaker(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
        }

   
    @GetMapping("/{id}")
    public ResponseEntity<Sneaker> getSneakerById(@PathVariable Long id) {
        Sneaker sneaker = sneakerService.searchById(id);
        if (sneaker != null) {
            return new ResponseEntity<>(sneaker, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/{name}")
    public ResponseEntity<Sneaker> getSneakerByName(@RequestBody String name) {
        Sneaker sneaker = sneakerService.searchByName(name);
        if (sneaker != null) {
            return new ResponseEntity<>(sneaker, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Sneaker>> getAllSneakers() {
        List<Sneaker> sneakers = (List<Sneaker>) sneakerService.searchAllSneakers();
        return new ResponseEntity<>(sneakers, HttpStatus.OK);
    }

}