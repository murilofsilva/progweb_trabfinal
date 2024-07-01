package com.ufms.progweb.controller;

import com.ufms.progweb.model.Sneaker;
import com.ufms.progweb.repository.SneakerRepository;
import com.ufms.progweb.services.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ufms.progweb.utils.StringUtils.isNullOrEmpty;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sneakers")
public class SneakerController {

    @Autowired
    private SneakerService sneakerService;

    @Autowired
    private SneakerRepository repository;

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
        if (sneakerService.searchById(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else {
            sneakerService.deleteSneaker(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
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
    public ResponseEntity getSneakerByName(@RequestBody String name) {
        List<Sneaker> sneaker = sneakerService.searchByName(name);
        return new ResponseEntity(HttpStatus.OK);
    }

    //@GetMapping("/filter/{size}/{brand}/{model}")
    //public ResponseEntity<List<Sneaker>> getSneakerByFilter(@RequestBody String size, String brand, String model) {
    //  List<Sneaker> sneakers = (List<Sneaker>) sneakerService.filterSneakers(size, brand, model);
    //return new ResponseEntity<>(sneakers, HttpStatus.OK);
    //}

    @GetMapping
    public ResponseEntity<List<Sneaker>> sneakers(@RequestParam(name = "filter", required = false) String filter,
                                                  @RequestParam(name = "gender", required = false) Character gender) {
        List<Sneaker> sneakers;
        if (!isNullOrEmpty(filter)) {
            sneakers = repository.findByNameContainingIgnoreCase(filter);
        } else if (gender != null){
            sneakers = repository.findByGender(gender);
        } else {
            sneakers = repository.findAll();
        }

        return new ResponseEntity<>(sneakers, HttpStatus.OK);
    }

}