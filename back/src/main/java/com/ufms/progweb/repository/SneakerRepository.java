package com.ufms.progweb.repository;

import com.ufms.progweb.model.Sneaker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SneakerRepository extends JpaRepository<Sneaker, Long> {
    List<Sneaker> findByName(String name);
    List<Sneaker> findByNameContainingIgnoreCase(String name);
    List<Sneaker> findByGender(Character gender);
    //Iterable<Sneaker> findByCriteria(String tamanho, String marca, String modelo);
}
