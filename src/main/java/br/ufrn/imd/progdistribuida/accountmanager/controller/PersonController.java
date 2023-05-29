package br.ufrn.imd.progdistribuida.accountmanager.controller;

import br.ufrn.imd.progdistribuida.accountmanager.dto.PersonPostRequest;
import br.ufrn.imd.progdistribuida.accountmanager.dto.PersonPostResponse;
import br.ufrn.imd.progdistribuida.accountmanager.model.Person;
import br.ufrn.imd.progdistribuida.accountmanager.repository.PersonRepository;
import br.ufrn.imd.progdistribuida.accountmanager.service.PersonService;
import br.ufrn.imd.progdistribuida.accountmanager.util.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoint.PERSON)
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonPostResponse> save(@RequestBody PersonPostRequest person) {
        return ResponseEntity.ok(personService.save(person));
    }
}
