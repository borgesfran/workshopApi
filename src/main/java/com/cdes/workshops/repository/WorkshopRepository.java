package com.cdes.workshops.repository;

import com.cdes.workshops.model.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WorkshopRepository extends JpaRepository<Workshop,Long> {

    Workshop findById(long id);

    @Query("select wk from Workshop wk where trim(upper( wk.nome) ) = trim(upper(:nome) ) ")
    Optional <Workshop> findByNome(String nome);

}
