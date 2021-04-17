package pl.sda.spring.citizensapp.person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Created by Tom - 17.04.2021
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "id", source = "id", ignore = true)
    Person toPerson(PersonCsvEntry personCsvEntry);


    Person createRequestToPerson(CreatePersonRequest person);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "birthDate", target = "birthDate")
    })
    PersonListView personToPersonListView(Person person);
}
