/**
 * 
 */
package com.carvalho.carrinho.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "tb_produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private double valorUnitario;
	
	@Builder.Default
	private Boolean disponivel = true;
	
	@ManyToOne
	@JsonIgnore
	private Restaurante restaurante;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
	

}
