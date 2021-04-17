package pl.sda.spring.citizensapp.person;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by Tom - 17.04.2021
 */
@Data
public class CreatePersonRequest {

    private String name;
    private String lastName;
    private String sex;
    private LocalDate birthDate;
}
