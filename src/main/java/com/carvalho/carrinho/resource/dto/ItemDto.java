/**
 * 
 */
package com.carvalho.carrinho.resource.dto;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author manoel.carvalho
 *
 */
@AllArgsConstructor
@Builder
@Data
@Embeddable
@NoArgsConstructor
public class ItemDto {
	private Long produtoId;
	private int quantidade;
	private Long sacolaId;
	
	public Long getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Long getSacolaId() {
		return sacolaId;
	}
	public void setSacolaId(Long sacolaId) {
		this.sacolaId = sacolaId;
	}
	
	
	
	
	

}
