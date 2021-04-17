package pl.sda.spring.citizensapp.person;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by Tom - 17.04.2021
 */
@Data
public class PersonListView {

    private String name;
    private LocalDate birthDate;
}
