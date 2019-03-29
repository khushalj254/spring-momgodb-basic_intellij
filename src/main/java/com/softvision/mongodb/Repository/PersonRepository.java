package com.softvision.mongodb.Repository;

import com.softvision.mongodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    Person findByFirstName(String name);
    List<Person> findByAge(int age);
    Set<Person> findByNameUnique();

}
