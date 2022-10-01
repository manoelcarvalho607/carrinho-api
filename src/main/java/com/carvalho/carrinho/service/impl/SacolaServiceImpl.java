/**
 * 
 */
package com.carvalho.carrinho.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.carvalho.carrinho.enumeration.FormaPagamento;
import com.carvalho.carrinho.model.Item;
import com.carvalho.carrinho.model.Restaurante;
import com.carvalho.carrinho.model.Sacola;
import com.carvalho.carrinho.repository.ItemRepository;
import com.carvalho.carrinho.repository.ProdutoRepository;
import com.carvalho.carrinho.repository.SacolaRepository;
import com.carvalho.carrinho.resource.dto.ItemDto;
import com.carvalho.carrinho.service.SacolaService;

import lombok.RequiredArgsConstructor;

/**
 * @author manoel.carvalho
 *
 */

@Service
@RequiredArgsConstructor
public class SacolaServiceImpl implements SacolaService{
	
	private final SacolaRepository sacolaRepository;
	private final ProdutoRepository produtoRepository;
	private final ItemRepository  itemRepository;
	
	public SacolaServiceImpl (SacolaRepository sacolaRepository, ProdutoRepository produtoRepository , ItemRepository  itemRepository) {
		this.sacolaRepository = sacolaRepository;
		this.produtoRepository = produtoRepository;
		this.itemRepository = itemRepository;
	}
	

	
	

	@Override
	public Item incluirItemNaSacola(ItemDto itemDto) {
		Sacola sacola = verSacola(itemDto.getSacolaId());
		
		if(sacola.isFechada()) {
			throw new RuntimeException("Esta sacola está Fechada.");
		}
		
		Item item = new Item();
		item.setQuantidade(itemDto.getQuantidade());
		item.setSacola(sacola);
		item.setProduto(produtoRepository.findById(itemDto.getProdutoId()).orElseThrow(
				() -> {
					throw new RuntimeException("Esse produto não existe!");
				}
			));
		
		List<Item> itensDaSacola = sacola.getItens();
		if(itensDaSacola.isEmpty()) {
			itensDaSacola.add(item);
		} else {
			Restaurante restauranteAtual = itensDaSacola.get(0).getProduto().getRestaurante();
			Restaurante restauranteAdicionar = item.getProduto().getRestaurante();
			if(restauranteAtual.equals(restauranteAdicionar)) {
				itensDaSacola.add(item);
			} else {
				throw new RuntimeException("Não é possível adicionar produtos de restaurantes diferentes!");
			}
			
		} 
		
		
		List<Double> valorItens = new ArrayList<>();
		
		for(Item itemSacola: itensDaSacola) {
			double valorTotalItem = itemSacola.getProduto().getValorUnitario() * itemSacola.getQuantidade();
			valorItens.add(valorTotalItem);
		}
		
		double valorTotalSacola = valorItens.stream()
			.mapToDouble(valorTotalDeCadaItem -> valorTotalDeCadaItem)
			.sum();
		
		sacola.setValorTotal(valorTotalSacola);
		sacolaRepository.save(sacola);
		
		return item;
	}

	@Override
	public Sacola verSacola(Long id) {
		
		return sacolaRepository.findById(id).orElseThrow(
				() -> {
					throw new RuntimeException("Essa sacola não existe!");
				}
			);
	}

	@Override
	public Sacola fecharSacola(Long id, int numeroFormaPagamento) {
		 Sacola sacola = verSacola(id);
		 
		 if(sacola.getItens().isEmpty()) {
			 throw new RuntimeException("Inclua itens na sacola!");
		 }
		 
		FormaPagamento formaPagamento = numeroFormaPagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;
		 
		sacola.setFormaPagamento(formaPagamento);
		sacola.setFechada(true);
		
		return sacolaRepository.save(sacola);
		
		
		
	}

}
