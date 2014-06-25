package com.gramer.address;

import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PersonTest {

    @Test
    public void testAge() throws Exception {
        Person p = new Person();
        p.setBirthday(new DateTime().withYear(1981).toDate());
        assertThat(p.age(), is(34));
    }

}