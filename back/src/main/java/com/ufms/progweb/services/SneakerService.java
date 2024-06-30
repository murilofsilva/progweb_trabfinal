package com.ufms.progweb.services;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ufms.progweb.model.Sneaker;
import com.ufms.progweb.repository.SneakerRepository;

@Service
public class SneakerService {
    
    @Autowired
    private SneakerRepository sneakerRepository;

    public Sneaker saveSneaker(Sneaker sneaker) {
        return sneakerRepository.save(sneaker);
    }

    public Sneaker updateSneaker(Long id, Sneaker sneakerDetails) {
        Sneaker sneaker = sneakerRepository.findById(id).orElse(null);
        if (sneaker != null) {
            sneaker.setName(sneakerDetails.getName());
            sneaker.setPrice(sneakerDetails.getPrice());
            sneaker.setDescription(sneakerDetails.getDescription());
            return sneakerRepository.save(sneaker);
        }
        return null;
    }

    public void deleteSneaker(Long id) {
        sneakerRepository.deleteById(id);
    }

    //public Iterable<Sneaker> filterSneakers(String size, String brand, String model) {
    //    return sneakerRepository.findByCriteria(size, brand, model);
    //}

    public Sneaker searchById(Long id) {
        return sneakerRepository.findById(id).orElse(null);
    }

    public Sneaker searchByName(String name) {
        return sneakerRepository.findByName(name);
    }

    public Iterable<Sneaker> searchAllSneakers() {
        return sneakerRepository.findAll();
    }
}
