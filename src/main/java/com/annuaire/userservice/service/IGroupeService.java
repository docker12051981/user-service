package com.annuaire.userservice.service;

import com.annuaire.userservice.dto.GroupeDto;
import com.annuaire.userservice.model.Groupe;

import java.util.List;


/**
 * @author karim hmadi

 * @description service interface groupe

 */
public interface IGroupeService {
    Groupe saveGroupe(GroupeDto groupeDto);
    List<Groupe> findAllGroupe();
    Groupe findGroupeById(String id);
    Groupe updateGroupe(String id, Groupe groupeRequest);
    Boolean deleteGroupe(String id);
}
