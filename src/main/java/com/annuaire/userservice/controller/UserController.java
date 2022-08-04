package com.annuaire.userservice.controller;

import com.annuaire.userservice.dto.UserDto;
import com.annuaire.userservice.model.User;
import com.annuaire.userservice.service.UserService;
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

 * @description  user controller

 */

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;
    @CrossOrigin(origins = "*")
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
    {
        logger.info("Methode createUser(): before : userDto : {} ", userDto);
        UserDto userstr= converter.userentityToDto(userService.saveUser(userDto));
        logger.info("Methode createUser(): after : userDto : {} ", userstr);
        return new ResponseEntity<>(userstr, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll() {

        List<User> listuser = userService.findAllUser();
        logger.info("Methode findAll(): after : userDto : {} ", converter.userentityToDto(listuser));
        return new ResponseEntity<List<UserDto>>(converter.userentityToDto(listuser), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable(name = "id") String id) {
        User user= userService.findUserById(id);
        // convert entity to DTO
        UserDto userResponse = converter.userentityToDto(user);
        logger.info("Methode findUserById(): after : userResponse : {} ", userResponse);
        return ResponseEntity.ok().body(userResponse);
    }

   /* @GetMapping("/structureId/{idstructure}")
    public ResponseEntity<List<UserDto>> findByStructureId(@PathVariable String idstructure)
    {
        List<User> findusersbystructureId= userService.findUserByStructureId(idstructure);
        return new ResponseEntity<List<UserDto>>(converter.userentityToDto(findusersbystructureId), HttpStatus.OK);
    }
*/
   @CrossOrigin(origins = "*")
    @GetMapping("/organismeId/{idorganisme}")
    public ResponseEntity<List<UserDto>> findByOrganismeId(@PathVariable String idorganisme)
    {
        List<User> findusersbyorganismeId= userService.findUserByOrganismeId(idorganisme);
        return new ResponseEntity<List<UserDto>>(converter.userentityToDto(findusersbyorganismeId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String id, @RequestBody UserDto UserDto) {
        // convert DTO to Entity
        logger.info("Methode updateUser(): before : UserDto : {} ", UserDto);
        User userRequest = converter.userdtoToEntity(UserDto);
        User user = userService.updateUser(id, userRequest);
        // entity to DTO
        UserDto userResponse = converter.userentityToDto(user);
        logger.info("Methode updateUser(): after : userResponse : {} ", userResponse);
        return ResponseEntity.ok().body(userResponse);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id) {
        Boolean deleted = false;
        if(id!=null)
        {
            deleted = userService.deleteUser(id);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}
