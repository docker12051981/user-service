package com.annuaire.userservice.model;

import com.annuaire.userservice.ennumeration.Roles;
import com.annuaire.userservice.ennumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author karim hmadi

 * @description user entity

 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private String id;
    @NotNull
    @Field("organisme")
    private String organismeId;
    @Field("groupes")
    @DBRef
    private List<Groupe> groupes;
    @Field("role")
    private Roles role;
    @NotNull
    @Field("identifiant")
    private String identifiant;
    @NotNull
    @Field("password")
    private String password;
    @NotNull
    @Field("status")
    private Status status;
    @NotNull
    @Field("email")
    private String email;
    private String createdBy;
    private LocalDateTime createTime;
}
