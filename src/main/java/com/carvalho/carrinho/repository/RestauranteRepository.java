/**
 * 
 */
package com.carvalho.carrinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carvalho.carrinho.model.Restaurante;

/**
 * @author manoel.carvalho
 *
 */

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

}
