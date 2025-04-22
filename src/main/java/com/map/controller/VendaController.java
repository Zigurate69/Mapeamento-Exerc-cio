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

import com.map.entities.Venda;
import com.map.services.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {
	
	private final VendaService vendaService;

	@Autowired
	public VendaController(VendaService vendaService) {
		this.vendaService = vendaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Venda> getVendaById(@PathVariable Long id) {
		Venda venda = vendaService.getVendaById(id);
		if (venda != null) {
			return ResponseEntity.ok(venda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Venda>> getAllVendas() {
		List<Venda> vendas = vendaService.getAllVenda();
		return ResponseEntity.ok(vendas);
	}

	@PostMapping("/")
	public ResponseEntity<Venda> criarVenda(@RequestBody Venda venda) {
		Venda criarVenda = vendaService.salvarVenda(venda);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarVenda);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Venda> updatedVenda(@PathVariable Long id, @RequestBody Venda venda) {
		Venda updatedVenda = vendaService.updateVenda(id, venda);
		if (updatedVenda != null) {
			return ResponseEntity.ok(updatedVenda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Venda> deleteVenda(@PathVariable Long id) {
		boolean deleted = vendaService.deleteVenda(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}