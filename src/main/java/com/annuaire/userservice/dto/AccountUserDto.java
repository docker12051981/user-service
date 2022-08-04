package com.annuaire.userservice.dto;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
/**
 * @author karim hmadi

 * @description  Account dto

 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountUserDto {

    private String id;
    private String login;
    private String password;
}
