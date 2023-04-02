package com.appempleos.busquedaempleos.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO implements Serializable {


    private Long id;
    @NotNull
    private String nombre;
    private String descripcion;
}
