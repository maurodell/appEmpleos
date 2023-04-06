package com.appempleos.busquedaempleos.service;

import com.appempleos.busquedaempleos.dto.CategoriaDTO;
import com.appempleos.busquedaempleos.model.Categoria;
import com.appempleos.busquedaempleos.repository.CategoriaRepository;
import com.appempleos.busquedaempleos.util.ServiceResult;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    public CategoriaRepository categoriaRepository;

    private ModelMapper modelMapper;
    public CategoriaDTO save(CategoriaDTO categoriaDTO){
        categoriaRepository.save(convertoToEntity(categoriaDTO));
        return categoriaDTO;
    }

    public ServiceResult delete(Long id) throws Exception{
        ServiceResult result = new ServiceResult();
        try{
            if(id == null){
                result.VALIDATION_BLOKING.add("El id no puede ser nulo");
                return result;
            }
            Optional<Categoria> findById = categoriaRepository.findById(id);
            if (findById.isPresent()){
                categoriaRepository.delete(findById.get());
                result.RESPONSE_DATA = "Se elimina de forma correcta la categoría";
            }else{
                result.VALIDATION_BLOKING.add("No se encontraron resultados con el Id: "+id);
                return result;
            }
            return result;
        }catch(Exception ex){
            throw new Exception("error delete "+ ex.getMessage());
        }
    }
    public CategoriaDTO convertToDTO(Categoria categoria){
        return modelMapper.map(categoria, CategoriaDTO.class);
    }
    public Categoria convertoToEntity(CategoriaDTO categoriaDTO){
        return  modelMapper.map(categoriaDTO, Categoria.class);
    }
}
