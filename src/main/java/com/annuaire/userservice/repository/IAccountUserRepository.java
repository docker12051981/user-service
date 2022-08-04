package com.annuaire.userservice.repository;


import com.annuaire.userservice.model.AccountUser;
import com.annuaire.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author karim hmadi

 * @description interface account repository

 */
@Repository
public interface IAccountUserRepository extends MongoRepository<AccountUser,String> {
}
