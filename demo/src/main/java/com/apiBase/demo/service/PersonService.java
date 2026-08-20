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
        return personRepository.findAll();
    }

    @Override
    public Person getPersonbyId(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person createPerson(Person person) {
        if(person == null){
            return null;
        }
        //el repository con el moetodo, nos trae el objeto entero ya con id de la db
        return personRepository.save(person);
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
