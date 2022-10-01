/**
 * 
 */
package com.carvalho.carrinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carvalho.carrinho.model.Produto;

/**
 * @author manoel.carvalho
 *
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
