package com.chanel.fsh.peps.nextgen.cms.db.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "cms_container")
public class CMSContainerEntity {
    @Id
    private Integer id;
    private String name;
}
