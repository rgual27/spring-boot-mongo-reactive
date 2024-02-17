package com.vass.reactiveservice.controller;

import com.vass.reactiveservice.dto.PersonAgeDto;
import com.vass.reactiveservice.dto.PersonDto;
import com.vass.reactiveservice.repository.PersonRepository;
import com.vass.reactiveservice.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "/api/persons")
@Slf4j
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping
  public Mono<ResponseEntity<List<PersonDto>>> all() {
    return personService.all()
        .collectList()
        .map(personDtos -> ResponseEntity.status(HttpStatus.OK).body(personDtos))
        .doOnError(throwable -> log.error(throwable.getMessage()));
  }

  @GetMapping("/age")
  public Mono<ResponseEntity<List<PersonAgeDto>>> allWithAge() {
    return personService.allWithAge()
            .collectList()
            .map(personDtos -> ResponseEntity.status(HttpStatus.OK).body(personDtos))
            .doOnError(throwable -> log.error(throwable.getMessage()));
  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<PersonDto>> byId(@PathVariable("id") String id) {
    return personService.byId(id)
        .map(ResponseEntity.status(HttpStatus.OK)::body)
        .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build())
        .doOnError(throwable -> log.error(throwable.getMessage()));
  }

  @PostMapping
  public Mono<ResponseEntity<PersonDto>> create(@RequestBody Mono<PersonDto> personDto) {
    return personService.create(personDto)
        .map(person -> ResponseEntity.status(HttpStatus.OK).body(person))
        .doOnError(throwable -> log.error(throwable.getMessage()));
  }
}
