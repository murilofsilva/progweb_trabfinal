package com.ufms.progweb.services;

import org.springframework.stereotype.Service;
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
            sneaker.setNome(sneakerDetails.getNome());
            sneaker.setPreco(sneakerDetails.getPreco());
            sneaker.setDescricao(sneakerDetails.getDescricao());
            return sneakerRepository.save(sneaker);
        }
        return null;
    }

    public void deleteSneaker(Long id) {
        sneakerRepository.deleteById(id);
    }

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
