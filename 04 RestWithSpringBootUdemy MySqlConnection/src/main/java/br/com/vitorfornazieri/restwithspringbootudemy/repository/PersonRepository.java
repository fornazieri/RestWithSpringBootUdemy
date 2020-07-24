package br.com.vitorfornazieri.restwithspringbootudemy.repository;

import br.com.vitorfornazieri.restwithspringbootudemy.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
