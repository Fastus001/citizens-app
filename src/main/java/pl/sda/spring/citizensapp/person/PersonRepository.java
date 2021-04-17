package pl.sda.spring.citizensapp.person;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tom - 17.04.2021
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
