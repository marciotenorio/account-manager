package br.ufrn.imd.progdistribuida.accountmanager.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "apps")
public class App {

    private String name;

    private AppType type;

    private Person person;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppType getType() {
        return type;
    }

    public void setType(AppType type) {
        this.type = type;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
