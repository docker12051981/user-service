package com.annuaire.userservice.service;

import com.annuaire.userservice.dto.GroupeDto;
import com.annuaire.userservice.dto.UserDto;
import com.annuaire.userservice.model.Groupe;
import com.annuaire.userservice.model.User;

import java.util.List;


/**
 * @author karim hmadi

 * @description service interface user

 */
public interface IUserService {
    User saveUser(UserDto userDto);
    List<User> findAllUser();
    User findUserById(String id);
    User updateUser(String id, User userRequest);
    Boolean deleteUser(String id);
    /*List<User> findUserByStructureId(String idstructure);*/
    List<User> findUserByOrganismeId(String idorganisme);
}
