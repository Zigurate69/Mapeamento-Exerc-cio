package com.map.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.entities.ItemVenda;
import com.map.repository.ItemVendaRepository;

@Service
public class ItemVendaService {
	
	private final ItemVendaRepository itemvendaRepository;
	
	@Autowired
	public ItemVendaService (ItemVendaRepository itemvendaRepository) {
		this.itemvendaRepository = itemvendaRepository;
	}
	
	public List<ItemVenda> getAllItemVenda() {
		return itemvendaRepository.findAll();
	}
	
	public ItemVenda getItemVendaById(Long id) {
		Optional<ItemVenda> itemvenda = itemvendaRepository.findById(id);
		return itemvenda.orElse(null);
	}
	
	public ItemVenda salvarItemVenda (ItemVenda itemvenda) {
		return itemvendaRepository.save(itemvenda);
	}
	
	public ItemVenda updateItemVenda (Long id, ItemVenda updatedItemVenda) {
		Optional<ItemVenda> existingItemVenda = itemvendaRepository.findById(id);
		if (existingItemVenda.isPresent()) {
			updatedItemVenda.setId(id);
			return itemvendaRepository.save(updatedItemVenda);
		} 
		return null;
	}
	
	public boolean deleteItemVenda (Long id) {
		Optional<ItemVenda> existingItemVenda = itemvendaRepository.findById(id);
		if (existingItemVenda.isPresent()) {
			itemvendaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}