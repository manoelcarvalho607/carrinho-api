/**
 * 
 */
package com.carvalho.carrinho.resource;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carvalho.carrinho.model.Item;
import com.carvalho.carrinho.model.Sacola;
import com.carvalho.carrinho.resource.dto.ItemDto;
import com.carvalho.carrinho.service.SacolaService;

import lombok.RequiredArgsConstructor;

/**
 * @author manoel.carvalho
 *
 */

@RestController
@RequestMapping("/ifood-devweek/sacolas")
@RequiredArgsConstructor
public class SacolaResource {
	
	
	private final SacolaService sacolaService;
	
	public SacolaResource(SacolaService sacolaService) {
		this.sacolaService = sacolaService;
	}
	
	
	@PostMapping
	public Item incluirItemNaSacola(@RequestBody ItemDto itemDto) {
		return sacolaService.incluirItemNaSacola(itemDto);
	}
	
	@GetMapping("/{id}")
	public Sacola verSacola(@PathVariable("id") Long  id) {
		return sacolaService.verSacola(id);
	}
	
	@PatchMapping("/fecharSacola/{sacolaId}")
	public Sacola fecharSacola(@PathVariable("sacolaId") Long sacolaId,@RequestParam("formaPagamento") int formaPagamento) {
		return sacolaService.fecharSacola(sacolaId, formaPagamento);
	}

}
