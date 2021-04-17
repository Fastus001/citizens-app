package pl.sda.spring.citizensapp.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tom - 17.04.2021
 */
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper mapper;


    public void saveAll(List<PersonCsvEntry> entries){

        final List<Person> collect = entries
                .stream()
                .map(mapper::toPerson)
                .collect(Collectors.toList());
        personRepository.saveAll(collect);
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }
}
