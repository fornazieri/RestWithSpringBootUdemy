package br.com.vitorfornazieri.restwithspringbootudemy.services;

import br.com.vitorfornazieri.restwithspringbootudemy.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service //serve para que o Spring cuide da injeção de dependencia desta classe onde for necessário, então eu não preciso dar um new nela, usando só o @Autowired e o spring ja faz isto
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    public Person create(Person person){
        //aqui fica a logica que persiste no banco de dados
        return person; //aqui retorna o objeto ja persistido
    }

    public Person update(Person person){
        //aqui fica a logica que persiste no banco de dados
        return person; //aqui retorna o objeto ja persistido
    }

    public void delete(String id){
        //a logica seria, receber id, procurar na base de dados, se existir deleta, se não existir lança uma exception
    }

    public Person findById(String id){
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Vitor");
        person.setLastName("Fornazieri");
        person.setAdress("Bilac - SP - Brasil");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll(){

        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Person Last Name " + i);
        person.setAdress("Some adress in Word " + i);
        person.setGender("Gender " + i);
        return person;
    }


}
