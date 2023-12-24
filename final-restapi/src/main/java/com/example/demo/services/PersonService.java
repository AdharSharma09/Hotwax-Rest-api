package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	public Person getPersonById(String partyId) {
		Optional<Person> optionalPerson = personRepository.findById(partyId);
		return optionalPerson.orElse(null);
	}

	public Person createPerson(Person person) {
		// You can perform any additional business logic or validation here before
		// saving
		return personRepository.save(person);
	}

	public Person updatePerson(String partyId, Person updatedPerson) {
		Optional<Person> optionalPerson = personRepository.findById(partyId);
		if (optionalPerson.isPresent()) {
			Person existingPerson = optionalPerson.get();
			// Update the fields you want to allow to be modified
			existingPerson.setFirstName(updatedPerson.getFirstName());
			existingPerson.setLastName(updatedPerson.getLastName());
			// Update other fields as needed
			return personRepository.save(existingPerson);
		}
		return null;
	}

	public void deletePerson(String partyId) {
		personRepository.deleteById(partyId);
	}
}
