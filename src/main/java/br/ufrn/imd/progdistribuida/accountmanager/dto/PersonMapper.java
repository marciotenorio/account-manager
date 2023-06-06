package br.ufrn.imd.progdistribuida.accountmanager.dto;

import br.ufrn.imd.progdistribuida.accountmanager.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person postRequestToPerson(PersonPostRequest personPostRequest);

    Person postResponseToPerson(PersonPostResponse personPostResponse);

    PersonPostResponse personToPostResponse(Person person);
}
