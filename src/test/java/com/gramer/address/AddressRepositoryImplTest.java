package com.gramer.address;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@ContextConfiguration(locations = {"classpath:/META-INF/spring/app-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AddressRepositoryImplTest {

    @Autowired
    private AddressRepository repository;

    @Test
    @Transactional
    public void insert() {
        Person p = new Person();
        p.setName("kkj");

        repository.insert(p);
        assertNotNull(p.getId());
    }

    @Test
    @Transactional
    public void find() {
        Person p = new Person();
        p.setName("kkj");

        repository.insert(p);

        List<Person> result = repository.findAll();
        assertThat(result.get(0).getName(), is(p.getName()));
    }


}