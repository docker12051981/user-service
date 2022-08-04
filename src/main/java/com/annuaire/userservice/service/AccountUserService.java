package com.annuaire.userservice.service;

import com.annuaire.userservice.dto.AccountUserDto;
import com.annuaire.userservice.dto.UserDto;
import com.annuaire.userservice.model.AccountUser;
import com.annuaire.userservice.model.User;
import com.annuaire.userservice.repository.IAccountUserRepository;
import com.annuaire.userservice.tools.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountUserService implements IAccountUserService {
    private final IAccountUserRepository accountUserRepository;
    public AccountUserService(IAccountUserRepository accountUserRepository) {
        super();
        this.accountUserRepository = accountUserRepository;
    }

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    public AccountUser saveAccountUser(AccountUserDto accountuserDto)
    {
        AccountUser accountuser = converter.accountToEntity(accountuserDto);
        accountuser.setPassword(bCryptPasswordEncoder.encode(accountuser.getPassword()));
        return accountUserRepository.save(accountuser);
    }

}
