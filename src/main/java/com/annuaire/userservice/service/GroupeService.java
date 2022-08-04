package com.annuaire.userservice.service;

import com.annuaire.userservice.dto.GroupeDto;
import com.annuaire.userservice.model.Groupe;
import com.annuaire.userservice.repository.IGroupeRepository;
import com.annuaire.userservice.tools.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author karim hmadi

 * @description service implement groupe

 */
@Service
public class GroupeService implements IGroupeService{
    private final IGroupeRepository groupeRepository;
    public GroupeService(IGroupeRepository groupeRepository) {
        super();
        this.groupeRepository = groupeRepository;
    }

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;

    @Override
    public Groupe saveGroupe(GroupeDto groupeDto)
    {
        Groupe groupe = converter.groupedtoToEntity(groupeDto);
       // groupe.setCreateTime(LocalDateTime.now());
        return groupeRepository.save(groupe);
    }

    @Override
    public List<Groupe> findAllGroupe()
    {
        return groupeRepository.findAll();
    }

    @Override
    public Groupe findGroupeById(String id) {
        Optional<Groupe> result = groupeRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new InvalidConfigurationPropertyValueException("Groupe", "id", id);
        }
    }

    @Override
    public Groupe updateGroupe(String id, Groupe groupeRequest) {
        Groupe groupe = groupeRepository.findById(id)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("Groupe", "id", id));
        groupe.setCode(groupeRequest.getCode());
        groupe.setName(groupeRequest.getName());
        groupe.setDescription(groupeRequest.getDescription());
        return groupeRepository.save(groupe);
    }

    @Override
    public Boolean deleteGroupe(String id) {
        groupeRepository.deleteById(id);
        return true;
    }
}
