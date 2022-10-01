/**
 * 
 */
package com.carvalho.carrinho.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.carvalho.carrinho.enumeration.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@Table(name = "tb_sacola")
public class Sacola {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> itens;
	
	private double valorTotal;
	
	@Enumerated
	private FormaPagamento formaPagamento;
	private boolean fechada;
	
	public List<Item> getItens() {
		return itens;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public boolean isFechada() {
		return fechada;
	}
	public void setFechada(boolean fechada) {
		this.fechada = fechada;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	

}
