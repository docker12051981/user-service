package com.annuaire.userservice.controller;

import com.annuaire.userservice.dto.GroupeDto;
import com.annuaire.userservice.model.Groupe;
import com.annuaire.userservice.service.GroupeService;
import com.annuaire.userservice.tools.Converter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author karim hmadi

 * @description groupe for user controller

 */

@Slf4j
@CrossOrigin(origins = "*")
@RestController
public class GroupeController {
    private static final Logger logger = LoggerFactory.getLogger(GroupeController.class);
    @Autowired
    GroupeService groupeService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;
    @CrossOrigin(origins = "*")
    @PostMapping("/users/group/add/")
    public ResponseEntity<GroupeDto> createGroupe(@RequestBody GroupeDto groupeDto)
    {
        logger.info("Methode createGroupe(): before : groupeDto : {} ", groupeDto);
        GroupeDto groupestr= converter.groupeentityToDto(groupeService.saveGroupe(groupeDto));
        logger.info("Methode createGroupe(): after : groupeDto : {} ", groupestr);
        return new ResponseEntity<>(groupestr, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/users/group/all")
    public ResponseEntity<List<GroupeDto>> findAll() {

        List<Groupe> listgroupe = groupeService.findAllGroupe();
        logger.info("Methode findAll(): after : groupeDto : {} ", converter.groupeentityToDto(listgroupe));
        return new ResponseEntity<List<GroupeDto>>(converter.groupeentityToDto(listgroupe), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/users/group/{id}")
    public ResponseEntity<GroupeDto> findGroupeById(@PathVariable(name = "id") String id) {
        Groupe groupe= groupeService.findGroupeById(id);
        // convert entity to DTO
        GroupeDto groupeResponse = converter.groupeentityToDto(groupe);
        logger.info("Methode findGroupeById(): after : groupeResponse : {} ", groupeResponse);
        return ResponseEntity.ok().body(groupeResponse);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/users/group/update/{id}")
    public ResponseEntity<GroupeDto> updateGroupe(@PathVariable String id, @RequestBody GroupeDto GroupeDto) {
        // convert DTO to Entity
        logger.info("Methode updateGroupe(): before : GroupeDto : {} ", GroupeDto);
        Groupe groupeRequest = converter.groupedtoToEntity(GroupeDto);
        Groupe groupe = groupeService.updateGroupe(id, groupeRequest);
        // entity to DTO
        GroupeDto groupeResponse = converter.groupeentityToDto(groupe);
        logger.info("Methode updateGroupe(): after : groupeResponse : {} ", groupeResponse);
        return ResponseEntity.ok().body(groupeResponse);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/users/group/delete/{id}")
    public ResponseEntity<Boolean> deleteGroupe(@PathVariable String id) {
        Boolean deleted = false;
        if(id!=null)
        {
            deleted = groupeService.deleteGroupe(id);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}
