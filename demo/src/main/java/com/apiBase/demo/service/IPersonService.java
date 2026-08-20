package com.apiBase.demo.service;

import com.apiBase.demo.model.Person;

import java.util.List;

public interface IPersonService {

    //metodos CRUD
    //get
    List<Person> getPerson();
    //getById
    Person getPersonbyId(Long id);
    //create
    Person createPerson(Person person);
    //update
    Person editPerson(Long id, Person person);
    //delete
    boolean deletePerson(Long id);
}
