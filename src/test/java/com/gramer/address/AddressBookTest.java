package com.gramer.address;

import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AddressBookTest {

    private static AddressBook addressBook;

    @BeforeClass
    public static void initialize() {
        addressBook = new AddressBook(Sets.newHashSet(
                new Person("kkj", new DateTime().withYear(1981).toDate()),
                new Person("kim", new DateTime().withYear(1981).toDate()),
                new Person("aaa", new DateTime().withYear(1981).toDate())
        ));
    }

    @Test
    public void findByName() {
        UnmodifiableIterator<Person> result = addressBook.findByNames("kkj");
        assertThat(result.next().getName(), is("kkj"));
    }

}