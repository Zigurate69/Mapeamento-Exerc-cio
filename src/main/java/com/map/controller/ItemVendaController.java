package com.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.entities.ItemVenda;
import com.map.services.ItemVendaService;

@RestController
@RequestMapping("/itemvenda")
public class ItemVendaController {

private final ItemVendaService itemvendaService;
	
	@Autowired
	public ItemVendaController (ItemVendaService itemvendaService) {
		this.itemvendaService = itemvendaService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemVenda> getProductById(@PathVariable Long id) {
		ItemVenda itemvenda = itemvendaService.getItemVendaById(id);
		if (itemvenda != null) {
			return ResponseEntity.ok(itemvenda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ItemVenda>> getAllItemVenda() {
		List <ItemVenda> itemvendas = itemvendaService.getAllItemVenda();
		return ResponseEntity.ok(itemvendas);
	}
	
	@PostMapping("/")
	public ResponseEntity<ItemVenda> criarItemVenda(@RequestBody ItemVenda itemvenda) {
		ItemVenda criarItemVenda = itemvendaService.salvarItemVenda(itemvenda);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarItemVenda);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemVenda> updatedCliente(@PathVariable Long id, @RequestBody ItemVenda itemvenda) {
		ItemVenda updatedItemVenda = itemvendaService.updateItemVenda(id, itemvenda);
		if (updatedItemVenda != null) {
			return ResponseEntity.ok(updatedItemVenda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ItemVenda> deleteItemVenda(@PathVariable Long id) {
		boolean deleted = itemvendaService.deleteItemVenda(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}