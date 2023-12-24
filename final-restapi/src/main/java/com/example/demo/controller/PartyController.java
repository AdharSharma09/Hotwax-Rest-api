package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Party;
import com.example.demo.services.PartyService;

@RestController
@RequestMapping("/api/parties")
public class PartyController {

	@Autowired
	private PartyService partyService;

	@GetMapping
	public List<Party> getAllParties() {
		return partyService.getAllParties();
	}

	@GetMapping("/{partyId}")
	public Party getPartyById(@PathVariable String partyId) {
		return partyService.getPartyById(partyId);
	}

	@PostMapping
	public Party createParty(@RequestBody Party party) {
		return partyService.createParty(party);
	}

	@PutMapping("/{partyId}")
	public Party updateParty(@PathVariable String partyId, @RequestBody Party party) {
		return partyService.updateParty(partyId, party);
	}

	@DeleteMapping("/{partyId}")
	public void deleteParty(@PathVariable String partyId) {
		partyService.deleteParty(partyId);
	}
}
