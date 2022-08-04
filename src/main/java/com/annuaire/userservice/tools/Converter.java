package com.annuaire.userservice.tools;

import com.annuaire.userservice.dto.AccountUserDto;
import com.annuaire.userservice.dto.GroupeDto;
import com.annuaire.userservice.dto.UserDto;
import com.annuaire.userservice.model.AccountUser;
import com.annuaire.userservice.model.Groupe;
import com.annuaire.userservice.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author karim hmadi

 * @description convert user dto to entity and entity to dto

 */
@Component
public class Converter {

    /** conert for Groupe **/
    public GroupeDto groupeentityToDto(Groupe groupe) {

        ModelMapper mapper =new ModelMapper();
        GroupeDto map = mapper.map(groupe, GroupeDto.class);
        return map;

    }
    public List<GroupeDto> groupeentityToDto(List<Groupe> groupe) {

        return	groupe.stream().map(x -> groupeentityToDto(x)).collect(Collectors.toList());

    }


    public Groupe groupedtoToEntity(GroupeDto groupedto) {

        ModelMapper mapper =new ModelMapper();
        Groupe map = mapper.map(groupedto, Groupe.class);
        return map;

    }
    public List<Groupe> groupedtoToEntity(List<GroupeDto> groupedto) {

        return	groupedto.stream().map(x -> groupedtoToEntity(x)).collect(Collectors.toList());

    }

    /** convert for User **/


    public UserDto userentityToDto(User user) {

        ModelMapper mapper =new ModelMapper();
        UserDto map = mapper.map(user, UserDto.class);
        return map;

    }
    public List<UserDto> userentityToDto(List<User> user) {

        return	user.stream().map(x -> userentityToDto(x)).collect(Collectors.toList());

    }


    public User userdtoToEntity(UserDto userdto) {

        ModelMapper mapper =new ModelMapper();
        User map = mapper.map(userdto, User.class);
        return map;
    }
    public List<User> userdtoToEntity(List<UserDto> userdto) {

        return	userdto.stream().map(x -> userdtoToEntity(x)).collect(Collectors.toList());
    }



    /** convert for Account **/


    public AccountUserDto accountentityToDto(AccountUser accountUser) {

        ModelMapper mapper =new ModelMapper();
        AccountUserDto map = mapper.map(accountUser, AccountUserDto.class);
        return map;

    }
    public List<AccountUserDto> accountentityToDto(List<AccountUser> accountUser) {

        return	accountUser.stream().map(x -> accountentityToDto(x)).collect(Collectors.toList());

    }


    public AccountUser accountToEntity(AccountUserDto accountUserdto) {

        ModelMapper mapper =new ModelMapper();
        AccountUser map = mapper.map(accountUserdto, AccountUser.class);
        return map;
    }
    public List<AccountUser> accountToEntity(List<AccountUserDto> accountUserdto) {

        return	accountUserdto.stream().map(x -> accountToEntity(x)).collect(Collectors.toList());
    }



}
