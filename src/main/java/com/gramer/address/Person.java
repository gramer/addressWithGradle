package com.gramer.address;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Date birthday;
    private String email;

    public Person(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public int age() {
        return new DateTime().getYear() - new DateTime(birthday).getYear() + 1;
    }
}
