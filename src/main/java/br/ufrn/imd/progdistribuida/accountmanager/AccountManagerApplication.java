package br.ufrn.imd.progdistribuida.accountmanager;

import br.ufrn.imd.progdistribuida.accountmanager.config.MongoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "br.ufrn.imd.progdistribuida.accountmanager")
@EnableMongoRepositories(basePackages = "br.ufrn.imd.progdistribuida.accountmanager.repository")
@EnableMongoAuditing
@Import(MongoConfig.class)
public class AccountManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountManagerApplication.class, args);
	}

}
