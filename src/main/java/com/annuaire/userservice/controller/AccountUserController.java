package com.annuaire.userservice.controller;

import com.annuaire.userservice.dto.AccountUserDto;
import com.annuaire.userservice.dto.GroupeDto;
import com.annuaire.userservice.service.AccountUserService;
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

@Slf4j
@CrossOrigin(origins = "*")
@RestController
public class AccountUserController {
    private static final Logger logger = LoggerFactory.getLogger(AccountUserController.class);
    @Autowired
    AccountUserService accountUserService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;
    @CrossOrigin(origins = "*")
    @PostMapping("/users/account/add/")
    public ResponseEntity<AccountUserDto> createAccount(@RequestBody AccountUserDto accountUserDto)
    {
        logger.info("Methode createAccountUser(): before : accountUserDto : {} ", accountUserDto);
        AccountUserDto accountuserstr= converter.accountentityToDto(accountUserService.saveAccountUser(accountUserDto));
        logger.info("Methode createAccountUser(): after : accountUserDto : {} ", accountuserstr);
        return new ResponseEntity<>(accountuserstr, HttpStatus.CREATED);
    }
}
