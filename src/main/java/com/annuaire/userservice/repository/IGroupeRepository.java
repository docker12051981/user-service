package com.annuaire.userservice.repository;


import com.annuaire.userservice.model.Groupe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author karim hmadi

 * @description interface groupe repository

 */
@Repository
public interface IGroupeRepository extends MongoRepository<Groupe,String> {
}
