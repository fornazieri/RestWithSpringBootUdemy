package br.com.vitorfornazieri.restwithspringbootudemy.services;

import br.com.vitorfornazieri.restwithspringbootudemy.converter.DozerConverter;
import br.com.vitorfornazieri.restwithspringbootudemy.data.vo.PersonVO;
import br.com.vitorfornazieri.restwithspringbootudemy.exception.ResourceNotFoundException;
import br.com.vitorfornazieri.restwithspringbootudemy.data.model.Person;
import br.com.vitorfornazieri.restwithspringbootudemy.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //serve para que o Spring cuide da injeção de dependencia desta classe onde for necessário, então eu não preciso dar um new nela, usando só o @Autowired e o spring ja faz isto
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public PersonVO create(PersonVO person){
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public List<PersonVO> findAll(){
        return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO person){
        var entity = repository.findById(person.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id){
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

}
