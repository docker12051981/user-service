package com.annuaire.userservice.service;

import com.annuaire.userservice.dto.UserDto;
import com.annuaire.userservice.model.User;
import com.annuaire.userservice.repository.IUserRepository;
import com.annuaire.userservice.tools.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author karim hmadi

 * @description service implement user

 */

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    public UserService(IUserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(UserDto userDto)
    {
        User user = converter.userdtoToEntity(userDto);
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUser()
    {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(String id) {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new InvalidConfigurationPropertyValueException("User", "id", id);
        }
    }

/*
    @Override
    public List<User> findUserByStructureId(String id) {
        return userRepository.findByStructureId(id);
    }
*/
    @Override
    public List<User> findUserByOrganismeId(String id)
    {
        return userRepository.findByOrganismeId(id);
    }

    @Override
    public User updateUser(String id, User userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("User", "id", id));
        user.setOrganismeId(userRequest.getOrganismeId());
        user.setGroupes(userRequest.getGroupes());
        user.setRole(userRequest.getRole());
        user.setIdentifiant(userRequest.getIdentifiant());
        user.setPassword(userRequest.getPassword());
        user.setStatus(userRequest.getStatus());
        user.setEmail(userRequest.getEmail());
        user.setCreatedBy(userRequest.getCreatedBy());
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }


    @Override
    public Boolean deleteUser(String id) {
        userRepository.deleteById(id);
        return true;
    }
}
