package com.example.demo.controller;

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

import com.example.demo.entities.Person;
import com.example.demo.services.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping
	public ResponseEntity<List<Person>> getAllPersons() {
		List<Person> persons = personService.getAllPersons();
		return new ResponseEntity<>(persons, HttpStatus.OK);
	}

	@GetMapping("/{partyId}")
	public ResponseEntity<Person> getPersonById(@PathVariable String partyId) {
		Person person = personService.getPersonById(partyId);
		return person != null ? new ResponseEntity<>(person, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		Person createdPerson = personService.createPerson(person);
		return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
	}

	@PutMapping("/{partyId}")
	public ResponseEntity<Person> updatePerson(@PathVariable String partyId, @RequestBody Person person) {
		Person updatedPerson = personService.updatePerson(partyId, person);
		return updatedPerson != null ? new ResponseEntity<>(updatedPerson, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{partyId}")
	public ResponseEntity<Void> deletePerson(@PathVariable String partyId) {
		personService.deletePerson(partyId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
