package com.appempleos.busquedaempleos.controller;

import com.appempleos.busquedaempleos.dto.PerfilDTO;
import com.appempleos.busquedaempleos.model.Perfil;
import com.appempleos.busquedaempleos.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/perfil")
public class PerfilController {
    @Autowired
    public PerfilService perfilService;
    private final Logger log = LoggerFactory.getLogger(Perfil.class);
    public ResponseEntity<Object> save(@Valid @RequestBody PerfilDTO perfilDTO){
        log.info("Se recibe DTO", perfilDTO);
        try {
            final PerfilDTO perfilDTO1 = perfilService.save(perfilDTO);
            return new ResponseEntity<>(perfilDTO1, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("Exception error - postPerfil "+ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
