package com.gramer.address;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import lombok.AllArgsConstructor;

import java.util.Set;

/**
 * Created by Administrator on 2014-06-25.
 */
@AllArgsConstructor
public class AddressBook {

    private Set<Person> people;

    public com.google.common.collect.UnmodifiableIterator<Person> findByNames(final String name) {
        return Iterators.filter(people.iterator(), new Predicate<Person>() {

            @Override
            public boolean apply(Person input) {
                return input.getName().equals(name);
            }
        });
    }

    public AddressBook insert(Person person) {
        people.add(person);
        return this;
    }

    public AddressBook delete(Person person) {
        people.remove(person);
        return this;
    }

    public AddressBook update(Person person) {
        // TODO update logic
        return this;
    }
}
