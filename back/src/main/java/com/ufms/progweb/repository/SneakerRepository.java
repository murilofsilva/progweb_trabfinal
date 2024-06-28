package com.ufms.progweb.repository;

import com.ufms.progweb.model.Sneaker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SneakerRepository extends JpaRepository<Sneaker, Long> {
    Sneaker findByName(String name);
    List<Sneaker> findByCriteria(String tamanho, String marca, String modelo);
}
