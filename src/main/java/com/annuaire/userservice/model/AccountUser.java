package com.annuaire.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "accountuser")
public class AccountUser {
    @Id
    private String id;

    @NotNull
    @Field("login")
    private String login;

    @NotNull
    @Field("password")
    private String password;
}

