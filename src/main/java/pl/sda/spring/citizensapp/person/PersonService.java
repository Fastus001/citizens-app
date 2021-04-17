package pl.sda.spring.citizensapp.person;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
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

    public Person addPerson(CreatePersonRequest person) {
        final Person personToSave = mapper.createRequestToPerson(person);
        return personRepository.save(personToSave);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<PersonListView> getAdults() {
        final LocalDate adultBirthDate = LocalDate.now().minusYears(30);

        return personRepository.findAdults(adultBirthDate)
                .stream()
                .map(mapper::personToPersonListView)
                .collect(Collectors.toList());

//        return personRepository.findAll().stream()
//                .filter(person -> Period.between(person.getBirthDate(), LocalDate.now()).getYears()>=35)
//                .map(mapper::personToPersonListView)
//                .collect(Collectors.toList());
    }

    public List<PersonListView> findByName(String name) {

//        return personRepository.findAll()
//                .stream()
//                .filter(person -> person.getName().equals(name))
//                .map(mapper::personToPersonListView)
//                .collect(Collectors.toList());
        return personRepository.findAllByName(name)
                .stream()
                .map(mapper::personToPersonListView)
                .collect(Collectors.toList());
    }

    public List<PersonListView> findByNameAndSex(String name, String sex) {
        return personRepository.findAllByNameAndSex(name,sex)
                .stream()
                .map(mapper::personToPersonListView)
                .collect(Collectors.toList());
    }

    public Page<PersonListView> getPage(Short page, Short size) {
        final PageRequest pageRequest = PageRequest.of(page, size);
        return personRepository.findAll(pageRequest)
                .map(mapper::personToPersonListView);
    }
}
