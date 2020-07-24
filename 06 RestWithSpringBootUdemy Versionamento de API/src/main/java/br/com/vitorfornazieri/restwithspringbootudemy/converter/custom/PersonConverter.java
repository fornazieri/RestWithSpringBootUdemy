package br.com.vitorfornazieri.restwithspringbootudemy.converter.custom;

import br.com.vitorfornazieri.restwithspringbootudemy.data.model.Person;
import br.com.vitorfornazieri.restwithspringbootudemy.data.vo.v2.PersonVOV2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonConverter {

    public PersonVOV2 convertEntityToVO(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setBirthDay(new Date());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        return vo;
    }

    public Person convertVOToEntity(PersonVOV2 personVOV2){
        Person entity = new Person();
        entity.setId(personVOV2.getId());
        entity.setAddress(personVOV2.getAddress());
        entity.setFirstName(personVOV2.getFirstName());
        entity.setLastName(personVOV2.getLastName());
        entity.setGender(personVOV2.getGender());
        return entity;
    }

}
