/*
 * Java domain class for entity "Car" 
 * Created on 2023-07-26 ( Date ISO 2023-07-26 - Time 21:42:57 )
 * Generated by Telosys Tools Generator ( version 4.0.0 )
 */
package org.demo.repositories;
import org.demo.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>CarRepository</h2>
 *
 * createdAt : 2023-07-26 - Time 21:42:57
 * <p>
 * Description: Spring Data repository for the {@link Car} entity.
 * 
 * @author aek
 */
@Repository
public interface CarRepository  extends JpaRepository<Car, int> , JpaSpecificationExecutor<Car> {

}