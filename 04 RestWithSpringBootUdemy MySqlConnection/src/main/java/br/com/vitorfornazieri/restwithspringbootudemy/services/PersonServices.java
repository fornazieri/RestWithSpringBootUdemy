package br.com.vitorfornazieri.restwithspringbootudemy.services;

import br.com.vitorfornazieri.restwithspringbootudemy.exception.ResourceNotFoundException;
import br.com.vitorfornazieri.restwithspringbootudemy.model.Person;
import br.com.vitorfornazieri.restwithspringbootudemy.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service //serve para que o Spring cuide da injeção de dependencia desta classe onde for necessário, então eu não preciso dar um new nela, usando só o @Autowired e o spring ja faz isto
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public Person create(Person person){
        //aqui fica a logica que persiste no banco de dados
        return repository.save(person); //aqui retorna o objeto ja persistido
    }

    public List<Person> findAll(){
        return repository.findAll();
    }

    public Person findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person update(Person person){
        //aqui fica a logica que persiste no banco de dados
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());
        return repository.save(entity); //aqui retorna o objeto ja persistido
    }

    public void delete(Long id){
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

}
