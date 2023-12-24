package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Party;
import com.example.demo.repository.PartyRepository;

@Service
public class PartyService {

	@Autowired
	private PartyRepository partyRepository;

	public List<Party> getAllParties() {
		return partyRepository.findAll();
	}

	public Party getPartyById(String partyId) {
		Optional<Party> findById = partyRepository.findById(partyId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	public Party createParty(Party party) {
		// Perform any necessary business logic/validation before saving
		return partyRepository.save(party);
	}

	public Party updateParty(String partyId, Party party) {
		// Validate if partyId exists, then update the party
		Party existingParty = getPartyById(partyId);
		existingParty.setPartyTypeEnumId(party.getPartyTypeEnumId());
		// Update other fields as needed

		return partyRepository.save(existingParty);
	}

	public void deleteParty(String partyId) {
		// Validate if partyId exists, then delete the party
		Party existingParty = getPartyById(partyId);
		partyRepository.delete(existingParty);
	}
}
