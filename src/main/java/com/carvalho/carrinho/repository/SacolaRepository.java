/**
 * 
 */
package com.carvalho.carrinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carvalho.carrinho.model.Sacola;

/**
 * @author manoel.carvalho
 *
 */

@Repository
public interface SacolaRepository extends JpaRepository<Sacola, Long>{

}
