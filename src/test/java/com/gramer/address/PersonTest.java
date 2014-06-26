package com.gramer.address;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testAge() throws Exception {
        Person p = new Person();
        p.setBirthday(new DateTime().withYear(1981).toDate());
        assertThat(p.age(), is(34));
    }

    @Test
    @Transactional
    public void testSave() {
        Person p = new Person();
        p.setBirthday(new Date());
        p.setName("kkj");
        p.setEmail("aa@gmail.com");
        entityManager.persist(p);
        assertNotNull(p.getId());
    }

}