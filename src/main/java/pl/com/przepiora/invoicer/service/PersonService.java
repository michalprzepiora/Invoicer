package pl.com.przepiora.invoicer.service;

import org.springframework.stereotype.Service;
import pl.com.przepiora.invoicer.model.Person;
import pl.com.przepiora.invoicer.repository.PersonRepository;

@Service
public class PersonService {
    PersonRepository personRepository;
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void save(Person person){
        personRepository.save(person);
    }
}
