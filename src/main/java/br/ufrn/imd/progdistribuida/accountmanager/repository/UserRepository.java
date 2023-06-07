package br.ufrn.imd.progdistribuida.accountmanager.repository;


import br.ufrn.imd.progdistribuida.accountmanager.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	User findByLogin(String login);
	
}
