package com.annuaire.userservice.dto;

import com.annuaire.userservice.ennumeration.Roles;
import com.annuaire.userservice.ennumeration.Status;
import com.annuaire.userservice.model.Groupe;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;
/**
 * @author karim hmadi

 * @description  user dto

 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private String organismeId;
    private List<Groupe> groupes;
    private Roles role;
    private String identifiant;
    private String password;
    private Status status;
    private String email;
    private String createdBy;
    private LocalDateTime createTime;
}
