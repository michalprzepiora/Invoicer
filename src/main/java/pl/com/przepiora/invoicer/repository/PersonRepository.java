package pl.com.przepiora.invoicer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.przepiora.invoicer.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
