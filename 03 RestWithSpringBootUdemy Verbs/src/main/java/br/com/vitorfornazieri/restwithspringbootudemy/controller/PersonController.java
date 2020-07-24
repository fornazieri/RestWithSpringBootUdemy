package br.com.vitorfornazieri.restwithspringbootudemy.controller;

import br.com.vitorfornazieri.restwithspringbootudemy.model.Person;
import br.com.vitorfornazieri.restwithspringbootudemy.request.converters.NumberConverter;
import br.com.vitorfornazieri.restwithspringbootudemy.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices services;

    @RequestMapping(method = RequestMethod.GET, //por padrão sempre é GET, quando não é especificado
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return services.findAll();
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET, //por padrão sempre é GET, quando não é especificado
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") String id) {
        return services.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, //por padrão sempre é GET, quando não é especificado
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return services.create(person);
    }

    @RequestMapping(method = RequestMethod.PUT, //por padrão sempre é GET, quando não é especificado
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return services.update(person);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE) //por padrão sempre é GET, quando não é especificado)
    public void delete(@PathVariable("id") String id) {
        services.delete(id);
    }

}
