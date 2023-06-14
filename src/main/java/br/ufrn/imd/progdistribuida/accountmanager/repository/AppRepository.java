package br.ufrn.imd.progdistribuida.accountmanager.repository;

import br.ufrn.imd.progdistribuida.accountmanager.model.App;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppRepository extends MongoRepository<App, String> {
    List<App> findAppByUserId(String userId);
}
