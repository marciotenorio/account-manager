package br.ufrn.imd.progdistribuida.accountmanager.service;

import br.ufrn.imd.progdistribuida.accountmanager.dto.PersonMapper;
import br.ufrn.imd.progdistribuida.accountmanager.dto.PersonPostRequest;
import br.ufrn.imd.progdistribuida.accountmanager.dto.PersonPostResponse;
import br.ufrn.imd.progdistribuida.accountmanager.model.Person;
import br.ufrn.imd.progdistribuida.accountmanager.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper mapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.mapper = personMapper;
    }

    public PersonPostResponse save(PersonPostRequest personPostRequest){
        Person person = mapper.postRequestToPerson(personPostRequest);
        person = personRepository.save(person);
        return mapper.personToPostResponse(person);
    }
}
