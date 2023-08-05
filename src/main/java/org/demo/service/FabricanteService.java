/*
*  Copyright (c) 2019. All right reserved
* Created on 2023-08-05 ( Date ISO 2023-08-05 - Time 10:29:13 )
* Generated by Telosys Tools Generator ( version 4.0.0 )
*/
package org.demo.service;
import org.demo.entities.Fabricante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Service Interface for managing {@link Fabricante}.
*  @author aek
 */
public interface FabricanteService  {
   
    /**
     * create new item for domain
     *
     * @param entity entity to save.
     * @return persisted entity Fabricante
     */
    Fabricante create(Fabricante d);

    /**
     * Update entity. Check before if existing data. If data is empty throw Exception
     *
     * @param entity domain
     * @param id of entity
     * @return Fabricante
     */
    Fabricante update(Fabricante d);

    /**
     * get Fabricante by id. Can be return empty
     *
     * @param id the id of the entity.
     * @return Fabricante
     */
    Fabricante getOne(int id) ;

    /**
     * Get all entities
     *
     * @return list of entities List<Fabricante>
     */
    List<Fabricante> getAll();

    /**
     * Count item in entity
     *
     * @return long 
     */
    long getTotal();

    /**
     * Delete record by id
     *  
     */
    void delete(int id);

    /**
     * Find all with pagination
     *
     * @return Page<Fabricante>  
     */
    Page<Fabricante> findAllPaginate(Pageable pageable);

    /**
     * Find all with pagination  by criteria 
     *
     * @return Page<Fabricante>  
     */
	Page<Fabricante> findAllSpecification(Specification<Fabricante> specs, Pageable pageable);

}
