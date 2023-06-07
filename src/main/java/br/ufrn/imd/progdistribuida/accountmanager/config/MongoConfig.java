package br.ufrn.imd.progdistribuida.accountmanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.ufrn.imd.AccountManager.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "account-manager"; // Nome do banco de dados MongoDB
    }

    // @Bean
    // public MongoTemplate mongoTemplate(MongoDatabaseFactory databaseFactory, MongoMappingContext mappingContext) {
    //     return new MongoTemplate(databaseFactory, mappingContext);
    // }
}
