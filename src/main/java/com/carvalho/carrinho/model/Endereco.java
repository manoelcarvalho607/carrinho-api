/**
 * 
 */
package com.carvalho.carrinho.model;


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
public class Endereco {
	
	private String cep;
	private String complemento;

}
