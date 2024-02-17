package com.vass.reactiveservice.service;

import com.vass.reactiveservice.dto.PersonAgeDto;
import com.vass.reactiveservice.dto.PersonDto;
import com.vass.reactiveservice.mapper.PersonMapper;
import com.vass.reactiveservice.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@AllArgsConstructor
@Primary
public class PersonServiceImpl implements PersonService {


    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    @Override
    public Flux<PersonDto> all() {
        return personRepository.findAll()
                .map(personMapper::asPerson);
    }

    @Override
    public Flux<PersonAgeDto> allWithAge() {
        return personRepository.findAll()
                .map(personMapper::asPersonAge);
    }

    @Override
    public Mono<PersonDto> byId(String id) {
        return personRepository.findById(id)
                .map(personMapper::asPerson);
    }

    @Override
    public Mono<PersonDto> create(Mono<PersonDto> person) {
        return person
                .map(this.personMapper::asPersonDocument)
                .flatMap(this.personRepository::save)
                .map(this.personMapper::asPerson)
                .doOnSuccess(s -> log.debug("End create Person"))
                .onErrorResume(throwable -> Mono.error(new RuntimeException("Se romp")));
    }

    @Override
    public Mono<PersonDto> update(Mono<PersonDto> person) {
        return person
                .map(this.personMapper::asPersonDocument)
                .flatMap(this.personRepository::save)
                .map(this.personMapper::asPerson)
                .doOnSuccess(s -> log.debug("End update Person"));
    }

    @Override
    public Mono<Void> delete(String id) {
        return Mono.just(id)
                .flatMap(this.personRepository::deleteById)
                .doOnSuccess(s -> {
                    log.debug("End delete Person");
                });
    }
}
