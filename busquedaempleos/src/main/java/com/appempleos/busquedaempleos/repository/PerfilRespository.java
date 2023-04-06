package com.appempleos.busquedaempleos.repository;

import com.appempleos.busquedaempleos.model.Perfil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRespository extends CrudRepository<Perfil, Long> {
}
