package pl.sda.spring.citizensapp.person;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Tom - 17.04.2021
 */
@Entity
@Data
@Accessors(chain = true)
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String lastName;
    private String sex;
    private LocalDate birthDate;

    @CreationTimestamp
    private LocalDateTime creationDate;
}
