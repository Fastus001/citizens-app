package pl.sda.spring.citizensapp.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Tom - 17.04.2021
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByName(String name);

    List<Person> findAllByNameAndSex(String name, String sex);

    default List<Person> findAdults(LocalDate adultBirthdate){
        return findAllByBirthDateBeforeOrderByBirthDate(adultBirthdate);
    }

    List<Person> findAllByBirthDateBeforeOrderByBirthDate(LocalDate date);

}
