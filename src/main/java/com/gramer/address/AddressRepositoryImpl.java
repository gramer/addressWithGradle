package com.gramer.address;

import com.gramer.dao.common.HibernateRepositoryImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2014-06-26.
 */
@Repository
public class AddressRepositoryImpl extends HibernateRepositoryImpl<Person> implements  AddressRepository {
}
