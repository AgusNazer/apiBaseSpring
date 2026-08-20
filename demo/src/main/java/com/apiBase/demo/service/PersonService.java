package com.apiBase.demo.service;

import com.apiBase.demo.model.Person;
import com.apiBase.demo.repository.IPersonRepository;

import java.util.List;

public class PersonService implements IPersonService{


    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private final IPersonRepository personRepository;

    @Override
    public List<Person> getPerson() {
        return List.of();
    }

    @Override
    public Person getPersonbyId(Long id) {
        return null;
    }

    @Override
    public Person createPerson(Person person) {
        return null;
    }

    @Override
    public Person editPerson(Long id, Person person) {
        return null;
    }

    @Override
    public boolean deletePerson(Long id) {
        return false;
    }
}
