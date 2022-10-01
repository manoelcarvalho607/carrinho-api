/**
 * 
 */
package com.carvalho.carrinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carvalho.carrinho.model.Cliente;

/**
 * @author manoel.carvalho
 *
 */

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
