/**
 * 
 */
package com.carvalho.carrinho.service;

import com.carvalho.carrinho.model.Item;
import com.carvalho.carrinho.model.Sacola;
import com.carvalho.carrinho.resource.dto.ItemDto;

/**
 * @author manoel.carvalho
 *
 */
public interface SacolaService {
	Item incluirItemNaSacola(ItemDto itemDto);
	Sacola verSacola(Long id);
	Sacola fecharSacola(Long id, int formaPagamento);
}
