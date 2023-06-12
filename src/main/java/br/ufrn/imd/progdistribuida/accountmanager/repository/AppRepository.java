package br.ufrn.imd.progdistribuida.accountmanager.repository;

import br.ufrn.imd.progdistribuida.accountmanager.model.App;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends MongoRepository<App, String> {
}
