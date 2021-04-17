package pl.sda.spring.citizensapp.person;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tom - 17.04.2021
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody CreatePersonRequest personRequest){
        return personService.addPerson(personRequest);
    }

//    @GetMapping
//    public List<Person> getAllPersons(){
//        return personService.findAll();
//    }

    @GetMapping("/adults")
    public List<PersonListView> getAdults(){
        return personService.getAdults();
    }

//    @GetMapping
//    public List<PersonListView> getByName(@RequestParam String name){
//        return personService.findByName(name);
//    }

    @GetMapping
    public List<PersonListView> getByNameAndSex(@RequestParam String name, @RequestParam String sex){
        return personService.findByNameAndSex(name, sex);
    }

    @GetMapping("/page")
    public Page<PersonListView> getPage(@RequestParam Short page, @RequestParam Short size){
        return personService.getPage(page,size);
    }
}
