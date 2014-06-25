package com.gramer.address;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by Administrator on 2014-06-25.
 */

@Data
@NoArgsConstructor
public class Person {

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
