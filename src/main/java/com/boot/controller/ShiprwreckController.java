package com.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepositoty;

@RestController
@RequestMapping("/api/v1")
public class ShiprwreckController {

	@Autowired
	private ShipwreckRepositoty shipwreckRepositoty;

	@GetMapping("/shipwrecks")
	public List<Shipwreck> list() {
		return shipwreckRepositoty.findAll();
	}

	@GetMapping("/shipwrecks/{id}")
	public Shipwreck get(@PathVariable Long id) {
		return shipwreckRepositoty.getOne(id);
	}

	@PostMapping("/shipwrecks")
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		return shipwreckRepositoty.saveAndFlush(shipwreck);
	}

	@PutMapping("/shipwrecks/{id}")
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
		Shipwreck existingShipwreck = shipwreckRepositoty.getOne(id);
		BeanUtils.copyProperties(shipwreck, existingShipwreck);
		return shipwreckRepositoty.saveAndFlush(existingShipwreck);
	}

	@DeleteMapping("/shipwrecks/{id}")
	public void delete(@PathVariable Long id) {
		shipwreckRepositoty.deleteById(id);
	}

}
