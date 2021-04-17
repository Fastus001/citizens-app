package pl.sda.spring.citizensapp.person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by Tom - 17.04.2021
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "id", source = "id", ignore = true)
    Person toPerson(PersonCsvEntry personCsvEntry);
}
