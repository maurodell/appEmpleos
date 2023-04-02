package com.appempleos.busquedaempleos.repository;

import com.appempleos.busquedaempleos.model.Categoria;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long> {
}
