package com.appempleos.busquedaempleos.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilDTO implements Serializable {
    private Long id;
    @NotNull
    private String perfil;
}
