package com.annuaire.userservice.dto.Request;

import com.annuaire.userservice.ennumeration.Roles;
import com.annuaire.userservice.model.Groupe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author karim hmadi

 * @description user request dto

 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserRequest {

    private String FonctionnaireId;
    private String OrganismeId;
    private String StructureId;
    private List<Groupe> Groupes;
    private Roles Role;
    private String Matricule;
    private String Password;
    private String createdBy;
    private LocalDateTime createTime;
}
