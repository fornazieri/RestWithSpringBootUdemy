package br.com.vitorfornazieri.restwithspringbootudemy.controller;

import br.com.vitorfornazieri.restwithspringbootudemy.data.model.Person;
import br.com.vitorfornazieri.restwithspringbootudemy.data.vo.PersonVO;
import br.com.vitorfornazieri.restwithspringbootudemy.data.vo.v2.PersonVOV2;
import br.com.vitorfornazieri.restwithspringbootudemy.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices services;

    @GetMapping
    public List<PersonVO> findAll() {
        return services.findAll();
    }

    @GetMapping("/{id}")
    public PersonVO findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }

    @PostMapping
    public PersonVO create(@RequestBody PersonVO person) {
        return services.create(person);
    }

    @PostMapping("/v2")
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
        return services.createV2(person);
    }

    @PutMapping
    public PersonVO update(@RequestBody PersonVO person) {
        return services.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) { //quando <?> significa que é generico, o que vier ele aceita
        services.delete(id);
        //return ResponseEntity.ok("Excluído com sucesso");
        return ResponseEntity.ok().build();
    }

}
