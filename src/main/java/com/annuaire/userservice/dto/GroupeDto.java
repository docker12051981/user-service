package com.annuaire.userservice.dto;

import lombok.*;


import java.time.LocalDateTime;

/**
 * @author karim hmadi

 * @description groupe for users dto

 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GroupeDto {
    private String id;
    private String code;
    private String name;
    private String description;
}
