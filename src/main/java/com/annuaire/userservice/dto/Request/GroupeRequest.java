package com.annuaire.userservice.dto.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author karim hmadi

 * @description groupe request dto

 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class GroupeRequest {
    private String code;
    private String name;
    private String description;
}
