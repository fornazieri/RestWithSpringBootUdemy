package br.com.vitorfornazieri.restwithspringbootudemy.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.vitorfornazieri.restwithspringbootudemy.data.vo.PersonVO;
import br.com.vitorfornazieri.restwithspringbootudemy.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Person Endpoint", description = "Description  for person", tags = {"person", "personEndpoint"})
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices services;

    @ApiOperation(value = "Find all people recorded")
    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<PersonVO> findAll() {
        List<PersonVO> persons = services.findAll();
        persons
                .stream()
                .forEach(p -> p.add(
                        linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()
                    )
                );
        return persons;
    }

    @ApiOperation(value = "Find person by ID")
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO findById(@PathVariable("id") Long id) {
        PersonVO personVO = services.findById(id);
        personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return personVO;
    }

    @ApiOperation(value = "Insert person")
    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO create(@RequestBody PersonVO person) {
        PersonVO personVO = services.create(person);
        personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
        return personVO;
    }

    @ApiOperation(value = "Update person by ID")
    @PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO update(@RequestBody PersonVO person) {
        PersonVO personVO = services.update(person);
        personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
        return personVO;
    }

    @ApiOperation(value = "Delete person by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) { //quando <?> significa que é generico, o que vier ele aceita
        services.delete(id);
        //return ResponseEntity.ok("Excluído com sucesso");
        return ResponseEntity.ok().build();
    }

}
