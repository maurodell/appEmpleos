package com.appempleos.busquedaempleos.service;

import com.appempleos.busquedaempleos.dto.PerfilDTO;
import com.appempleos.busquedaempleos.model.Perfil;
import com.appempleos.busquedaempleos.repository.PerfilRespository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    public PerfilRespository perfilRespository;
    private ModelMapper modelMapper;

    public PerfilDTO save(PerfilDTO perfilDTO){
        perfilRespository.save(convertToEntity(perfilDTO));
        return perfilDTO;
    }

    public PerfilDTO convertToDTO(Perfil perfil){
        return modelMapper.map(perfil, PerfilDTO.class);
    }
    public Perfil convertToEntity(PerfilDTO perfilDTO){
        return modelMapper.map(perfilDTO, Perfil.class);
    }
}
