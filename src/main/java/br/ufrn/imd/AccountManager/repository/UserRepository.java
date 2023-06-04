package br.ufrn.imd.AccountManager.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.imd.AccountManager.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	User findByLogin(String login);
	
}
