package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    public PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person createPerson(Person person) {
        return repository.save(person);
    }

    public Iterable<Person> getPersonList() {
        return repository.findAll();
    }

    public Person getPerson(int id) {
        return repository.findById(id).get();
    }

    public Person updatePerson(int id, Person newPersonData) {
        Person ogPerson = repository.findById(id).get();
        ogPerson.setFirstName(newPersonData.getFirstName());
        ogPerson.setLastName(newPersonData.getLastName());
        return repository.save(ogPerson);
    }

    public Boolean deletePerson(int id) {
        repository.deleteById(id);
        return true;
    }


}
