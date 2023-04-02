package com.appempleos.busquedaempleos.service;

import com.appempleos.busquedaempleos.dto.CategoriaDTO;
import com.appempleos.busquedaempleos.model.Categoria;
import com.appempleos.busquedaempleos.repository.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    public CategoriaRepository categoriaRepository;
    @Autowired
    private ModelMapper modelMapper;
    public CategoriaDTO save(CategoriaDTO categoriaDTO){
        categoriaRepository.save(convertoToEntity(categoriaDTO));
        return categoriaDTO;
    }

    public CategoriaDTO convertToDTO(Categoria categoria){
        return modelMapper.map(categoria, CategoriaDTO.class);
    }
    public Categoria convertoToEntity(CategoriaDTO categoriaDTO){
        return  modelMapper.map(categoriaDTO, Categoria.class);
    }
}
