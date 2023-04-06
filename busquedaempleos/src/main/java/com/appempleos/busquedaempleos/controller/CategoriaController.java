package com.appempleos.busquedaempleos.controller;

import com.appempleos.busquedaempleos.dto.CategoriaDTO;
import com.appempleos.busquedaempleos.model.Categoria;
import com.appempleos.busquedaempleos.service.CategoriaService;
import com.appempleos.busquedaempleos.util.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
    @Autowired
    public CategoriaService categoriaService;
    private final Logger log = LoggerFactory.getLogger(Categoria.class);
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> save(@Valid @RequestBody CategoriaDTO categoriaDTO){
        log.info("Se recibe DTO", categoriaDTO);
        try {
            final CategoriaDTO categoriaDTO1 = categoriaService.save(categoriaDTO);
            return new ResponseEntity<>(categoriaDTO1, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("Exception error - postCategoria "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        log.info("Se recibe id: ", id);
        try {
            ServiceResult response = categoriaService.delete(id);
            if(response.VALIDATION_BLOKING.isEmpty()){
                if(response.VALIDATION_MILD.isEmpty()){
                    return new ResponseEntity<>(response.getResponse().get("responseData"), HttpStatus.OK);
                }else{
                    return new ResponseEntity<>(response.getResponse(), HttpStatus.PARTIAL_CONTENT);
                }
            }else {
                return new ResponseEntity<>(response.getResponse(), HttpStatus.CONFLICT);
            }
        }catch (Exception ex){
            return new ResponseEntity<>("Exception error - delete "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
