package br.ufrn.imd.progdistribuida.accountmanager.repository;

import br.ufrn.imd.progdistribuida.accountmanager.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
}
