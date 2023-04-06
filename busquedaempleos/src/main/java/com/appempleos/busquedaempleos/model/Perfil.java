package com.appempleos.busquedaempleos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "perfil")
@Data
public class Perfil implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "perfil")
    private String perfil;
}
