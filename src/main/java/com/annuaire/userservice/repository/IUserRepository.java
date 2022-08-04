package com.annuaire.userservice.repository;

import com.annuaire.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author karim hmadi

 * @description interface user repository

 */

@Repository
public interface IUserRepository extends MongoRepository<User,String> {
  /*  List<User> findByStructureId(String id);*/

    List<User> findByOrganismeId(String id);
}
