/**
 * 
 */
package com.carvalho.carrinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carvalho.carrinho.model.Item;

/**
 * @author manoel.carvalho
 *
 */

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
